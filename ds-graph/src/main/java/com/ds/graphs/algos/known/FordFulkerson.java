package com.ds.graphs.algos.known;

import com.ds.graphs.algos.GraphWithAdjMatrix;
import com.ds.graphs.algos.util.Pair;

import java.util.*;

public class FordFulkerson {
    //To solve max flow problem from source to sink
    /**
     * Goal : Find out how much stuff can be pushed from the source to sink. Max flow problem.
     * Rules: Flow <= capacity and incoming == outgoing except source and sink
     * Weight of graph edge is the capacity
     */

    public static int fordFulkerson(int[][] graph,int src,int sink){
        int[] parent = new int[graph.length];
        parent[src] = 0;
        int[][] residualGraph = graph;
        int minCapacity=0,maxFlow=0;

        while(true){
            minCapacity = bfs(src, sink, parent, residualGraph);
            //min capacity zero means no path available
            if(minCapacity==0) break;
            maxFlow+=minCapacity;
            int u= sink; //start from sink go to parent, and keep going bottom up till we find src again
            while(u!=src){
                int v = parent[u];
                residualGraph[u][v]+=minCapacity; //residual capacity
                residualGraph[v][u]-=minCapacity; //forward. remember v is Parent.
                u=v;
            }
        }
        return maxFlow;
    }


    //Go over the graph, find min capacity in the graph from src to sink
    private static int bfs(int src, int sink, int[] parent, int[][] residualGraph) {
        Arrays.fill(parent,-1);
        parent[src] = -2;
        Queue<Pair<Integer>> q = new LinkedList<>();
        q.offer(Pair.of(src,Integer.MAX_VALUE));

        while(q.isEmpty()==false){
            int u = q.peek().getLeft();
            int capacity = q.peek().getRight();
            q.poll();
            for(int av=0;av<residualGraph.length;av++){
                if(u!=av && parent[av]==-1 && residualGraph[u][av]!=0){
                    parent[av] = u;
                    int minCapacity = Math.min(capacity,residualGraph[u][av]);
                    if(av == sink)
                        return minCapacity;
                    q.offer(Pair.of(av,minCapacity));
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        GraphWithAdjMatrix graphWithAdjMatrix = new GraphWithAdjMatrix(6);
        graphWithAdjMatrix.addEdge(0,1,4);
        graphWithAdjMatrix.addEdge(0,3,3);
        graphWithAdjMatrix.addEdge(1,2,4);
        graphWithAdjMatrix.addEdge(2,3,3);
        graphWithAdjMatrix.addEdge(2,5,2);
        graphWithAdjMatrix.addEdge(3,4,6);
        graphWithAdjMatrix.addEdge(4,5,6);

        int graph[][] = new int[][] {
                { 0, 16, 13, 0, 0, 0 }, { 0, 0, 10, 12, 0, 0 },
                { 0, 4, 0, 0, 14, 0 },  { 0, 0, 9, 0, 0, 20 },
                { 0, 0, 0, 7, 0, 4 },   { 0, 0, 0, 0, 0, 0 }
        };

        System.out.println(fordFulkerson(graphWithAdjMatrix.getGraph(),0,5));
        System.out.println(fordFulkerson(graph,0,5));

    }

}
