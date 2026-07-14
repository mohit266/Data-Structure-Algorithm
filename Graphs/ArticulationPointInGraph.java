package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArticulationPointInGraph {

    public static void main(String[] args) {

        ArticulationPointInGraph a = new ArticulationPointInGraph();
        int V = 7;

        List<List<Integer>> adj= Arrays.asList(
                List.of(1,2,3),
                List.of(0),
                List.of(0, 3, 4, 5),
                List.of(2, 0),
                List.of(2, 6),
                List.of(2, 6),
                List.of(4, 5)
        );

        System.out.println(a.articulationPoints(V, adj));
    }

    int timer = 0;

    public ArrayList<Integer> articulationPoints(int n, List<List<Integer>> adj) {

        boolean[] vis = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        boolean[] artiPoint = new boolean[n];

        for (int i = 0; i < n; i++){
            if (!vis[i]){
                dfs(i, -1, vis, tin, low, artiPoint, adj);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (artiPoint[i]) {
                ans.add(i);
            }
        }

        if (ans.isEmpty())
            return new ArrayList<>(List.of(-1));

        return ans;
    }

    public void dfs(int node, int parent, boolean[] vis, int[] tin, int[] low, boolean[] artiPoint, List<List<Integer>> adj){
        vis[node] = true;
        low[node] = tin[node] = timer;
        timer++;

        int childNode = 0;

        for (int adjNode : adj.get(node)){
            if (adjNode == parent) continue;

            if (!vis[adjNode]){

                dfs(adjNode, node, vis, tin, low, artiPoint, adj);

                low[node] = Math.min(low[node], low[adjNode]);

                if (low[adjNode] >= tin[node] && parent != -1){
                    artiPoint[node] = true;
                }

                childNode++;

            } else {
                low[node] = Math.min(tin[adjNode], low[node]);
            }
        }

        if (childNode > 1 && parent == -1){
            artiPoint[node] = true;
        }
    }

}
