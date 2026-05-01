package com.dsa.StackAndQueues;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, DLLNode> mpp;
    private int cap;
    private DLLNode head;
    private DLLNode tail;

    public LRUCache(int capacity) {
        cap = capacity;
        mpp = new HashMap<>();

        head = new DLLNode(-1, -1);
        tail = new DLLNode(-1, -1);

        head.next = tail;
        tail.back = head;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        int[][] nums = {{1, 1, 1}, {1, 2, 2}, {2, 1}, {1, 3, 3}, {2, 2}, {1, 4, 4}, {2, 1}, {2, 3}, {2, 4}};

        for (int[] op : nums) {
            if (op[0] == 1) {
                lruCache.put(op[1], op[2]);
            } else if (op[0] == 2) {
                System.out.println(lruCache.get(op[1]));
            } else {
                System.out.println("Invalid operation");
            }
        }


    }

    public int get(int key) {
        if (!mpp.containsKey(key))
            return -1;

        DLLNode node = mpp.get(key);
        int val = node.value;

        deleteNode(node);
        insertAfterHead(node);

        return val;
    }

    public void put(int key, int value) {

        if (mpp.containsKey(key)) {

            DLLNode node = mpp.get(key);
            node.value = value;

            deleteNode(node);

            insertAfterHead(node);

            return;
        }

        if (mpp.size() == cap) {

            DLLNode node = tail.back;

            mpp.remove(node.key);

            deleteNode(node);
        }

        DLLNode newNode = new DLLNode(key, value);

        mpp.put(key, newNode);
        insertAfterHead(newNode);
    }

    private void deleteNode(DLLNode node) {

        DLLNode prevNode = node.back;
        DLLNode nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.back = prevNode;
    }

    private void insertAfterHead(DLLNode node) {

        DLLNode nextNode = head.next;
        head.next = node;
        nextNode.back = node;
        node.back = head;
        node.next = nextNode;
    }

}


    /*

    public DLLNode head;
    public DLLNode tail;
    public int leftCapacity;
    public HashMap<Integer, DLLNode> map;

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
//        int[][] nums = {{1, 1, 1}, {1, 2, 2}, {2, 1}, {1, 3, 3}, {2, 2}, {1, 4, 4}, {2, 1}, {2, 3}, {2, 4} };
        int[][] nums = {{1,1, 1}, {1,2, 2}, {2,1}, {1,3, 3}, {2,2}, {1,4, 4}, {2,3}};

        for (int[] op : nums) {
            if (op[0] == 1) {
                lruCache.put(op[1], op[2]);
            } else if (op[0] == 2) {
                System.out.println(lruCache.get(op[1]));
            } else {
                System.out.println("Invalid operation");
            }
        }


    }

    public LRUCache(int capacity) {
        this.leftCapacity = capacity;

        head = new DLLNode(-1, -1);
        tail = new DLLNode(-1, -1);

        head.next = tail;
        tail.back = head;

        map = new HashMap<>();
    }

    public int get(int key) {
        DLLNode node = map.get(key);
        if (node == null){
            System.out.println("Key doest not exist");
            return -1;
        }
        updateLRUNode(key, -1, "get");
        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)){
            updateLRUNode(key, value, "put");
            return;
        }

        if (leftCapacity <= 0){
            deleteLeastRecentlyNode();
        }

        addNewNode(key, value);
    }

    public void updateLRUNode(int key, int value, String operation){
        DLLNode temp = head;

        DLLNode keyNode = map.get(key);
        DLLNode node = null;

        while (temp.next != null){
            if (temp == keyNode){
                node = temp;
                break;
            }
            temp = temp.next;
        }

        if (node != null){
            DLLNode prev = node.back;
            DLLNode next = node.next;

            prev.next = next;
            next.back = prev;

            if ("put".equals(operation)){
                node.value = value;
                System.out.println("Key : " + key + " updated with new value : "+value);
            }

            DLLNode front = head.next;
            head.next = node;
            node.next = front;
            front.back = node;

        }

    }

    private void addNewNode(int key, int value) {
        DLLNode newNode = new DLLNode(key, value);

        DLLNode front = head.next;
        head.next = newNode;
        newNode.next = front;
        newNode.back = head;
        front.back = newNode;

        map.put(key, newNode);
        leftCapacity--;

        System.out.println("New node added with key : " +key+ " and value is : " +value);
    }

    public void deleteLeastRecentlyNode(){
        DLLNode lruNode = tail.back;
        DLLNode prev = lruNode.back;

        prev.next = tail;
        tail.back = prev;

        map.remove(lruNode.key);
        leftCapacity++;

        System.out.println("LRU node deleted and key was : "+lruNode.key);
    }
    */
