package com.ds.graphs.algos.known;

import com.ds.graphs.algos.GraphWithAdjMatrix;

import java.util.Arrays;
import java.util.List;

public class BellmanFord {

    //Dijkstra's algo doesn't work for -ve edges. Bellman-Ford works for negative weight cycles.
    //This algo is used for finding the shortest path from a source.

    public static void shortestPath(int[][] graph,int start,List<List<Integer>> edges){
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start]=0;
        for(int i=0;i<graph.length;i++){
            for(List<Integer> edge: edges){
                if(dist[edge.get(1)] > dist[edge.get(0)] + graph[edge.get(0)][edge.get(1)])
                    dist[edge.get(1)] = dist[edge.get(0)] + graph[edge.get(0)][edge.get(1)];
            }
        }

        for(List<Integer> edge: edges){
            if(dist[edge.get(1)] > dist[edge.get(0)] + graph[edge.get(0)][edge.get(1)])
                System.out.println("Negative edge cycle exists");
        }

        System.out.println(Arrays.toString(dist));
    }


    /**
     * The reason Dijkstra doesn't work for -ve weight cycles is because it doesn't revisit vertex once its marked visited.
     *
     * Another point with Single-Source-Shortest-Path algo is if there is a cycle they will keep going in same path as cost will
     * keep decreasing   b ==(1)== D , this cycle is -ve weight.
     *                   2\      /-4
     *                       C
     *  Bellman-Ford algo return false if a negative weight cycle exists. else it can return the shortest path
     * @param args
     */
    public static void main(String[] args) {
        GraphWithAdjMatrix graphWithAdjMatrix = new GraphWithAdjMatrix(5);
        graphWithAdjMatrix.addEdge(0,1,4);
        graphWithAdjMatrix.addEdge(0,2,2);
        graphWithAdjMatrix.addEdge(1,3,2);
        graphWithAdjMatrix.addEdge(1,4,3);
        graphWithAdjMatrix.addEdge(1,2,3);
        graphWithAdjMatrix.addEdge(2,1,1);
        graphWithAdjMatrix.addEdge(2,4,5);
        graphWithAdjMatrix.addEdge(2,3,4);
        graphWithAdjMatrix.addEdge(4,3,-5);
        graphWithAdjMatrix.display();
        shortestPath(graphWithAdjMatrix.getGraph(),0,graphWithAdjMatrix.getEdges());

    }
}
