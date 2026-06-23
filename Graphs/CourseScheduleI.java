package com.dsa.Graphs;

import java.util.*;

public class CourseScheduleI {
    public static void main(String[] args) {
        CourseScheduleI d = new CourseScheduleI();
        int V = 6;
        List<List<Integer>> adj= Arrays.asList(
                List.of(1),
                Arrays.asList(2,5),
                List.of(3),
                List.of(4),
                List.of(1),
                List.of()
        );

        System.out.println(d.isCyclic(V, adj));
        System.out.println(d.isCyclicUsingTopoSort(V, adj));
    }

    public boolean isCyclic(int N, List<List<Integer>> adj) {

        boolean[] visitedMp = new boolean[N];

        for (int i = 0; i < N; i++){
            if (!visitedMp[i]){
                boolean[] pathMp = new boolean[N];
                if(dfsTraversal(i, visitedMp, pathMp, adj)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCyclicUsingTopoSort(int N, List<List<Integer>> adj) {
        return topoSort(N, adj);
    }

    private boolean dfsTraversal(int node, boolean[] visitedMp, boolean[] pathMp, List<List<Integer>> adj) {
        visitedMp[node] = true;
        pathMp[node] = true;

        List<Integer> neighbourLs = adj.get(node);
        for (int n : neighbourLs){
            if (!visitedMp[n]){
                if (dfsTraversal(n, visitedMp, pathMp, adj)){
                    return true;
                }
            } else if (pathMp[n]){
                return true;
            }
        }
        pathMp[node] = false;
        return false;
    }


    // for bfs we can generate topo sort

    public boolean topoSort(int V, List<List<Integer>> adj){

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

        List<Integer> res = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);

            for (int n : adj.get(node)){
                inDegree[n]--;
                if (inDegree[n] == 0){
                    q.offer(n);
                }
            }
        }

        return res.size() < adj.size();
    }

}
