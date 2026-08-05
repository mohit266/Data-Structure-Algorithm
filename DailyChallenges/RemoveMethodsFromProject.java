package com.dsa.DailyChallenges;

import java.util.*;

public class RemoveMethodsFromProject {

    public static void main(String[] args) {

        RemoveMethodsFromProject r = new RemoveMethodsFromProject();

        int n = 4;
        int k = 1;
        int[][] invocations = {{1,2},{0,1},{3,2}};

        System.out.println(r.remainingMethods(n, k, invocations));

    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] edge : invocations){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }

        boolean[] suspicious = new boolean[n];

        bfs(k, suspicious, adj);

        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];

            if (!suspicious[u] && suspicious[v]) {
                List<Integer> ans = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }

                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    public void bfs(int node, boolean[] suspicious, List<List<Integer>> adj){

        Queue<Integer> q = new LinkedList<>();
        q.offer(node);


        while (!q.isEmpty()){

            int n = q.poll();
            suspicious[n] = true;

            for (Integer newNode : adj.get(n)){
                if (!suspicious[newNode]){
                    q.offer(newNode);
                }
            }
        }
    }



}
