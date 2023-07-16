package com.ds.graphs.algos.known;

import java.util.*;

public class DisjointSets {
    //useful to:
    // Krushkal's algo of MST
    // Detect cycle in an undirected graph:
    // 1- Create set for each vertex.
    // 2- process each edge of graph, and do find and union on both vertex of edge.
    // 3- if find returns same set for both vertex of any edge then it's a cycle.



    public static Set<Integer> union(Set<Integer> set1,Set<Integer> set2){
        Set<Integer> union = new HashSet<>();
        union.addAll(set1);
        union.addAll(set2);
        return union;
    }

    public static Optional<Set<Integer>> find(int x, List<Set<Integer>> sets){
        return sets.stream().filter(set-> set.contains(x)).findAny();
    }

    public static Set<Integer> makeSet(int x){
        Set<Integer> set = new HashSet<>();
        set.add(x);
        return set;
    }


    public static void main(String[] args) {
        List<Set<Integer>> sets = new ArrayList<>();
        for(int i=0;i<10;i++)
            sets.add(makeSet(i));

        System.out.println(sets);
        System.out.println(union(sets.get(2),sets.get(1)));
    }
}
