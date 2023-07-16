package com.ds.graphs.algos.known;

import com.ds.graphs.algos.GraphWithAdjMatrix;

import java.util.Arrays;
import java.util.List;

public class FloydWarshal {

    //Another algo for finding the shortest path, other are Dijkstra and Bellman-Ford.
    //Floyd-Warshal is used to find the shortest path between all the pairs of vertices in a weighted graph.

    public static void shortestPath(int[][] graph,int start,List<List<Integer>> edges){
        int[][] DIST = new int[graph.length][graph[0].length];
        for(int i=0;i<graph.length;i++) {
            Arrays.fill(DIST[i],Integer.MAX_VALUE);
            DIST[i][i] = 0;//self
        }

        for(List<Integer> edge: edges)
            DIST[edge.get(0)][edge.get(1)] = edge.get(2);

        for(int k=0;k<graph.length;k++){
            for(int i=0;i<graph.length;i++)
                for(int j=0;j<graph[0].length;j++) {
                    if(DIST[i][k]!= Integer.MAX_VALUE && DIST[k][j]!=Integer.MAX_VALUE)
                    DIST[i][j] = Math.min(DIST[i][j], DIST[i][k] + DIST[k][j]);
                }
        }

        for(int i=0;i<DIST.length;i++)
            System.out.println(i+"->"+Arrays.toString(DIST[i]));
    }

    public static void main(String[] args) {
        GraphWithAdjMatrix graphWithAdjMatrix = new GraphWithAdjMatrix(5);
        graphWithAdjMatrix.addEdge(0,1,3);
        graphWithAdjMatrix.addEdge(0,4,-4);
        graphWithAdjMatrix.addEdge(0,2,8);
        graphWithAdjMatrix.addEdge(1,3,1);
        graphWithAdjMatrix.addEdge(1,4,7);
        graphWithAdjMatrix.addEdge(2,1,4);
        graphWithAdjMatrix.addEdge(3,0,2);
        graphWithAdjMatrix.addEdge(3,2,-5);
        graphWithAdjMatrix.addEdge(4,3,6);
        graphWithAdjMatrix.display();
        System.out.println("Floyd warshal ============");
        shortestPath(graphWithAdjMatrix.getGraph(),0,graphWithAdjMatrix.getEdges());
    }

}
