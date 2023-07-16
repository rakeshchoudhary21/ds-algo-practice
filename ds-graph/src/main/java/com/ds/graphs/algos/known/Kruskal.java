package com.ds.graphs.algos.known;

import com.ds.graphs.algos.GraphWithAdjMatrix;

import java.math.BigDecimal;
import java.util.*;

public class Kruskal {
    /**
     * Greedy algo for finding MST.
     * steps:
     * for each vertex in graph, make a set.
     * sort all edges in ascending order of weight
     *
     * for each edge in sorted_order
     *  if(find(u) != find (v))
     *  then: add edge in result and union u and v
     *
     *  return result
     */

    public static List<List<Integer>> mst(int[][] graph,List<List<Integer>> edges){
        List<Set<Integer>> sets = makeSets(graph);
        Collections.sort(edges, Comparator.comparing(l -> l.get(2)));
        List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> edge: edges){
            if(DisjointSets.find(edge.get(0),sets).get() != DisjointSets.find(edge.get(1),sets).get()){
                result.add(edge);
            }
            Set<Integer> set1 = DisjointSets.find(edge.get(0),sets).get();
            Set<Integer> set2 = DisjointSets.find(edge.get(1),sets).get();
            sets.remove(set1);
            sets.remove(set2);
            sets.add(DisjointSets.union(set1,set2));
        }
        return result;
    }

    private static List<Set<Integer>> makeSets(int[][] graph) {
        List<Set<Integer>> sets = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++)
                if(graph[i][j]>0){
                    if(sets.contains(DisjointSets.makeSet(i))==false) sets.add(DisjointSets.makeSet(i));
                    if(sets.contains(DisjointSets.makeSet(j))==false) sets.add(DisjointSets.makeSet(j));
                }
        }
        return sets;
    }

    public static void main(String[] args) {
        GraphWithAdjMatrix graph = new GraphWithAdjMatrix(7);
        graph.addEdge(0,1,2);
        graph.addEdge(0,3,7);
        graph.addEdge(0,5,2);
        graph.addEdge(1,2,1);
        graph.addEdge(1,3,4);
        graph.addEdge(1,4,3);
        graph.addEdge(1,5,5);
        graph.addEdge(2,4,4);
        graph.addEdge(2,5,4);
        graph.addEdge(3,4,1);
        graph.addEdge(3,6,5);
        graph.addEdge(4,6,7);
        System.out.println(mst(graph.getGraph(),graph.getEdges()));

        System.out.println(BigDecimal.valueOf(Double.valueOf("0.83")).intValue());
    }
}
