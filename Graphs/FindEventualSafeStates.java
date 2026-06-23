package com.dsa.Graphs;

import java.util.*;

public class FindEventualSafeStates {
    public static void main(String[] args) {
        FindEventualSafeStates f = new FindEventualSafeStates();

        int V = 7;
        int[][] adj= {{1,2}, {2,3}, {5}, {0}, {5}, {}, {}};

        System.out.println(Arrays.toString(f.eventualSafeNodes(V, adj)));
        System.out.println(Arrays.toString(f.eventualSafeNodesDFS(V, adj)));

    }

    public int[] eventualSafeNodes(int V, int[][] adj) {

        List<List<Integer>> adjLs = new ArrayList<>();

        // Reverse graph.
        for (int i = 0; i < V; i++){
            adjLs.add(new ArrayList<>());
        }

        for (int i = 0; i < adj.length; i++){
            int[] arr = adj[i];
            for (int n : arr){
                adjLs.get(n).add(i);
            }
        }

        int [] inDegree = new int[V];

        for (List<Integer> li : adjLs){
            for (int n : li){
                inDegree[n]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++){
            if (inDegree[i] == 0){
                q.offer(i);
            }
        }

        List<Integer> ls = new ArrayList<>();

        while (!q.isEmpty()){
            int node = q.poll();
            ls.add(node);

            for (int n : adjLs.get(node)){
                inDegree[n]--;
                if (inDegree[n] == 0){
                    q.offer(n);
                }
            }
        }

        Collections.sort(ls);

        int i = 0;
        int[] result = new int[ls.size()];
        while (i < ls.size()){
            result[i] = ls.get(i);
            i++;
        }

        return result;
    }

    // Using DFS Approach.
    public int[] eventualSafeNodesDFS(int V, int[][] adj) {

        boolean[] visitedMp = new boolean[V];
        boolean[] path = new boolean[V];
        boolean[] safeNode = new boolean[V];


        for (int i = 0; i < V; i++){
            if (!visitedMp[i]){
                dfsTraversal(i, visitedMp, path, safeNode, adj);
            }
        }

        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < V; i++){
            if (safeNode[i]){
                ls.add(i);
            }
        }

        int i = 0;
        int [] res = new int[ls.size()];
        while (i < ls.size()){
            res[i] = ls.get(i);
            i++;
        }

        return res;
    }

    public boolean dfsTraversal(int node, boolean[] visitedMp, boolean[] path, boolean[] safeNode, int[][] adj) {
        visitedMp[node] = true;
        path[node] = true;
        safeNode[node] = false;

        for (int n : adj[node]){
            if (!visitedMp[n]){
                if (dfsTraversal(n, visitedMp, path, safeNode, adj)){
                    return true;
                }
            } else if (path[n]){
                return true;
            }
        }

        safeNode[node] = true;
        path[node] = false;

        return false;
    }

}
