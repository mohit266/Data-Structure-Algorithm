package com.dsa.DailyChallenges;

import com.dsa.Graphs.DisjointSet;

import java.util.*;

public class PathExistenceQueriesInAGraphI {

    public static void main(String[] args) {
        int n = 4;
        int[] nums = {2,5,6,8};
        int maxDiff = 2;
        int[][] queries =  {{0,1},{0,2},{1,3},{2,3}};

        PathExistenceQueriesInAGraphI p = new PathExistenceQueriesInAGraphI();

        System.out.println(Arrays.toString(p.pathExistenceQueries(n, nums, maxDiff, queries)));
    }


    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        boolean[] result = new boolean[queries.length];

        DisjointSet ds = new DisjointSet(n);

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                ds.unionBySize(i - 1, i);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            result[i] = ds.find(u,v);
        }

        return result;
    }

}
