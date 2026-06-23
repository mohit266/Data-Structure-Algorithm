package com.dsa.Graphs;

import java.util.*;

public class CourseScheduleII {
    public static void main(String[] args) {
        CourseScheduleII c = new CourseScheduleII();

        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};

        System.out.println(Arrays.toString(c.findOrder(numCourses, prerequisites)));

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        for (int[] ary : prerequisites) {
            int u = ary[1];
            int v = ary[0];

            adj.get(u).add(v);
            inDegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++){
            if (inDegree[i] == 0){
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

        int [] res = new int[ls.size()];
        int i = 0;

        while (i < ls.size()){
            res[i] = ls.get(i);
            i++;
        }

        return res;
    }

}
