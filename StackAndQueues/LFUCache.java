package com.dsa.StackAndQueues;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    private Map<Integer, DLLNode> keyNode;
    private Map<Integer, List> freqListMap;
    private int maxSizeCache;
    private int minFreq;
    private int curSize;

     public LFUCache(int capacity) {
        maxSizeCache = capacity;
        minFreq = 0;
        curSize = 0;
        keyNode = new HashMap<>();
        freqListMap = new HashMap<>();
    }


    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(5);
//        int[][] nums = {{1, 1, 1}, {1, 2, 2}, {2, 1}, {1, 3, 3}, {2, 2}, {2,3}, {1, 4, 4}, {2, 1}, {2, 3}, {2, 4}};
        int[][] nums = {{2,5},{1,6,96},{1,8,43},{1,5,76},{1,6,98},{1,6,7},{1,6,93},{2,4},{2,9},{2,2},{1,4,7},
                {2,5},{2,7},{2,5},{1,5,83},{1,3,16},{1,8,29},{2,3},{1,2,76},{2,3},{2,3},{1,10,95},{1,8,97},{2,1},
                {1,5,94},{1,3,59},{1,6,14},{1,5,25},{2,3},{2,6},{2,9},{2,9},{2,6},{1,1,62},{2,2}};

        for (int[] op : nums) {
            if (op[0] == 1) {
                lfuCache.put(op[1], op[2]);
            } else if (op[0] == 2) {
                System.out.println(lfuCache.get(op[1]));
            } else {
                System.out.println("Invalid operation");
            }
        }
    }

    public int get(int key) {
         if (!keyNode.containsKey(key)){
             return -1;
         }

         DLLNode node = keyNode.get(key);
         int val = node.value;
         updateFreqListMap(node);
         return val;
    }

    public void put(int key, int value) {
        if (maxSizeCache == 0) {
            return;
        }

        if (keyNode.containsKey(key)) {
            DLLNode node = keyNode.get(key);
            node.value = value;
            updateFreqListMap(node);
        } else {
            if (curSize == maxSizeCache) {
                List list = freqListMap.get(minFreq);
                keyNode.remove(list.tail.back.key);

                freqListMap.get(minFreq).removeNode(list.tail.back);
                curSize--;
            }
            curSize++;

            minFreq = 1;

            List listFreq = new List();

            if (freqListMap.containsKey(minFreq)) {
                listFreq = freqListMap.get(minFreq);
            }

            DLLNode node = new DLLNode(key, value);

            listFreq.addFront(node);

            keyNode.put(key, node);

            freqListMap.put(minFreq, listFreq);
        }
    }

    private void updateFreqListMap(DLLNode node) {
        keyNode.remove(node.key);

        List linkedList = freqListMap.get(node.cnt);
        linkedList.removeNode(node);

        if (node.cnt == minFreq && freqListMap.get(node.cnt).size == 0) {
            minFreq++;
        }

        List nextHigherFreqList = new List();

        if (freqListMap.containsKey(node.cnt + 1)) {
            nextHigherFreqList = freqListMap.get(node.cnt + 1);
        }

        node.cnt += 1;

        nextHigherFreqList.addFront(node);

        freqListMap.put(node.cnt, nextHigherFreqList);
        keyNode.put(node.key, node);
    }


}
