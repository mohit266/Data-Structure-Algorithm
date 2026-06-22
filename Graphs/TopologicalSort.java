package com.dsa.Graphs;

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        TopologicalSort t = new TopologicalSort();

        int V = 6;
        List<List<Integer>> adj= Arrays.asList(
                List.of(),
                List.of(),
                List.of(3),
                List.of(1),
                Arrays.asList(0,1),
                Arrays.asList(0,2)
        );

        System.out.println(Arrays.toString(t.topoSort(V, adj)));
        System.out.println(Arrays.toString(t.topoSortKahnAlgo(V, adj)));


    }

    public int[] topoSort(int V, List<List<Integer>> adj) {

        boolean[] visitedMp = new boolean[V];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++){
            if (!visitedMp[i]){
                dfs(i, visitedMp, st, adj);
            }
        }

        int[] result = new int[V];
        int i = 0;

        while(!st.isEmpty()){
            result[i++] = st.pop();
        }

        return result;
    }

    public void dfs(int node, boolean[] visitedMp, Stack<Integer> st, List<List<Integer>> adj){
        visitedMp[node] = true;

        List<Integer> adjacentEle = adj.get(node);

        for (int n : adjacentEle){
            if (!visitedMp[n]){
                dfs(n, visitedMp, st, adj);
            }
        }
        st.push(node);
    }


    // Using kahn's algo
    public int[] topoSortKahnAlgo(int V, List<List<Integer>> adj) {

        int[] inDegree = new int[V];
        Arrays.fill(inDegree, 0);

        for (List<Integer> ls : adj){
            for (int n : ls){
                inDegree[n]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++){
            if (inDegree[i] == 0){
                q.offer(i);
            }
        }

        int[] result = new int[V];

        int i = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            result[i++] = node;

            List<Integer> neighbourAdjLs = adj.get(node);

            for (int n : neighbourAdjLs){
                inDegree[n]--;
                if (inDegree[n] == 0){
                    q.offer(n);
                }
            }
        }

        return result;
    }

}
