package com.dsa.Graphs;

import java.util.HashMap;
import java.util.Map;

public class MostStonesRemovedWithSameRowOrColumn {

    public static void main(String[] args) {

        MostStonesRemovedWithSameRowOrColumn m = new MostStonesRemovedWithSameRowOrColumn();

        int[][] stones = {{40,28},{22,39},{44,46},{17,42},{5,45},{6,36},{21,1},{48,26},{35,1},{29,25},{40,40},{48,36},{22,13},{42,39}};

        System.out.println(m.removeStones(stones));

    }

    public int removeStones(int[][] stones) {
        int n = stones.length;

        int maxRow = 0;
        int maxCol = 0;

        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);

        Map<Integer, Integer> stoneNodes = new HashMap<>();

        for (int[] stone : stones) {
            int nodeRow = stone[0];
            int nodeCol = stone[1] + maxRow + 1;

            ds.unionBySize(nodeRow, nodeCol);

            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }

        int k = 0;

        for (int key : stoneNodes.keySet()) {
            if (ds.findParent(key) == key) {
                k++;
            }
        }

        return n - k;
    }



}
