package com.dsa.Graphs;

import java.util.Arrays;

public class DisjointSet {

    int[] size;
    int[] range;
    int[] parent;

    public DisjointSet(int n){
        size = new int[n+1];
        parent = new int[n+1];
        range = new int[n+1];

        for (int i = 0; i <= n; i++){
            parent[i] = i;
        }
        Arrays.fill(size, 1);
    }


    public int findParent(int node){
        if (parent[node] == node){
            return node;
        }

        parent[node] = findParent(parent[node]);
        return parent[node];
    }

    public boolean find(int u, int v) {
        return findParent(u) == findParent(v);
    }

    public void unionBySize(int u, int v){
        int up_u = findParent(u);
        int up_v = findParent(v);

        if (size[up_u] < size[up_v]){
            parent[up_u] = up_v;
            size[up_v] += size[up_u];
        } else {
            parent[up_v] = up_u;
            size[up_u] += size[up_v];
        }
    }

    public void unionByRank(int u, int v){
        int up_u = findParent(u);
        int up_v = findParent(v);

        if (up_u == up_v) return;

        int rankU = range[up_u];
        int rankV = range[up_v];

        if (rankU < rankV){
            parent[up_u] = up_v;
        } else if (rankV < rankU){
            parent[up_v] = up_u;
        } else {
            parent[up_v] = up_u;
            range[up_u]++;
        }
    }
}
