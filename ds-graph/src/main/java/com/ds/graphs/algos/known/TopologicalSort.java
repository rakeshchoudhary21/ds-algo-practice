package com.ds.graphs.algos.known;

import com.ds.graphs.algos.GraphWithAdjMatrix;

import java.util.*;

public class TopologicalSort {

    //visit all dependencies before a node itself
    //ex: 1-> 2 -> 3, 2->4 then topological sort is: [3,4] , 2, 1

    private static void topologicalSortRec(int[][] graph, Set<Integer> visited, int start,Queue<Integer> result) {
        visited.add(start);
        for(int i=0;i<graph[start].length;i++){
            if(visited.contains(i)==false && graph[start][i]!=0)
                topologicalSortRec(graph,visited,i,result);
        }
        result.add(start);
    }

    public static void main(String[] args) {
        GraphWithAdjMatrix graph = new GraphWithAdjMatrix(5);
        graph.addEdge(0,1,1);
        graph.addEdge(0,2,1);
        graph.addEdge(1,2,1);
        graph.addEdge(1,3,1);
        graph.addEdge(2,3,1);
        graph.addEdge(2,4,1);
        Queue<Integer> result = new LinkedList<>();
        topologicalSortRec(graph.getGraph(),new HashSet<>(),1,result);
        System.out.println(result);

    }

}
