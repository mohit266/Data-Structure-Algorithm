package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    public static void main(String[] args) {
        AlienDictionary a = new AlienDictionary();

        int N = 5;
        int K = 4;
        String[] dict = {"baa","abcd","abca","cab","cad"};

        System.out.println(a.findOrder(dict, N, K));
    }

    public String findOrder(String [] dict, int N, int K) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < K; i++){
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < dict.length - 1; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];

            int len = Math.max(s1.length(), s2.length());
            for (int index = 0; index < len; index++) {
                if (s1.charAt(index) != s2.charAt(index)) {
                    adj.get(s1.charAt(index) - 'a').add(s2.charAt(index) - 'a');
                    break;
                }
            }
        }

        int[] inDegree = new int[N];

        for (List<Integer> ls : adj){
            for (int n : ls){
                inDegree[n]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < K; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        List<Integer> ls = new ArrayList<>();

        while (!q.isEmpty()){
            int node = q.poll();
            ls.add(node);

            for (int n : adj.get(node)){
                inDegree[n]--;
                if (inDegree[n] == 0){
                    q.offer(n);
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < K; i++) {
            ans.append((char) ('a' + ls.get(i)));
            ans.append(' ');
        }

        return ans.toString();
    }
}
