package com.dsa.DailyChallenges;

import java.util.*;
import java.util.stream.IntStream;

// TODO : Three test cases are failing out of 1001.
public class ShortestPathWithAtMostKConIdeChar {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1,1},{1,2,1}};
        String labels = "aaa";
        int k = 2;

        ShortestPathWithAtMostKConIdeChar s = new ShortestPathWithAtMostKConIdeChar();
        System.out.println(s.shortestPath(n, edges, labels, k));
    }

    public int shortestPath(int n, int[][] edges, String labels, int k) {

        List<List<int[]>> adj = new ArrayList<>();

        IntStream.range(0,n).forEach(i -> adj.add(new ArrayList<>()));

        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int dis = edge[2];

            adj.get(u).add(new int[]{v, dis});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Object[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> (int) a[1]));
        q.offer(new Object[]{0, 0, labels.charAt(0)});
        dist[0] = 0;

        while(!q.isEmpty()){
            Object[] cell = q.poll();

            int node = (int) cell[0];
            int nodeDis = (int) cell[1];
            String nodeLabel = String.valueOf(cell[2]);

            for (int[] neighbor : adj.get(node)){
                int nei = neighbor[0];
                int neiDis = neighbor[1];
                char neiLabel = labels.charAt(nei);

                if (isValid(nodeLabel,neiLabel, k) && nodeDis + neiDis < dist[nei]){
                    dist[nei] = nodeDis + neiDis;
                    String res = nodeLabel.length() > k ? nodeLabel.substring(nodeLabel.length() - k) : nodeLabel;
                    q.offer(new Object[]{nei, dist[nei], res + neiLabel});
                }
            }
        }

        for (int i = 0; i < n; i++){
            if (dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }

        return dist[n-1];
    }

    public boolean isValid(String s, char c, int k){

        char[] arr = s.toCharArray();

        for (int i = arr.length - 1; i >= 0; i--){

            if (arr[i] == c && k <= 1){
                return false;
            }

            if (arr[i] != c){
                return true;
            }

            if (arr[i] == c){
                k--;
            }

        }
        return true;
    }
}
