package com.dsa.Graphs;

public class DisjointSetMain {
    public static void main(String[] args) {

        DisjointSet ds = new DisjointSet(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        if (ds.find(3, 7))
            System.out.println("They belong to the same components.");
        else
            System.out.println("They do not belong to the same components.");

        ds.unionBySize(3, 7);

        if (ds.find(3, 7))
            System.out.println("They belong to the same components.");
        else
            System.out.println("They do not belong to the same components.");
    }
}
