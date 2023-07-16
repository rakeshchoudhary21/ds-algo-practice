package com.ds.graphs.algos.known;

import com.ds.graphs.algos.GraphWithAdjMatrix;
import org.apache.commons.lang3.tuple.Pair;


import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {

    /**
     * This algo is used for finding the shortest path between nodes in a graph. (all nodes-shortest path)
     * Can be used to find the shortest path from single node to all other nodes in graph
     */

    public static void dijkstra(int[][] graph,int start){
        int[] dist = new int[graph.length];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start]=0;//dist of start from itself is zero
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((p1, p2) -> p1.getValue()-p2.getValue());
        pq.offer(Pair.of(start,0));
        while(pq.isEmpty()==false){
            Pair<Integer,Integer> curr_min = pq.poll(); //key is the node, value is its dist
            int node = curr_min.getKey();
            for(int i=0;i<graph[node].length;i++){
                if(graph[node][i]!=0) { //check if there is actually an edge.
                    int cost = graph[node][i];
                    if (dist[i] > dist[node] + cost) {
                        dist[i] = dist[node] + cost;
                        pq.offer(Pair.of(i,dist[node] + cost));
                    }
                }
            }
        }

        System.out.println(Arrays.toString(dist));
    }

    public static void main(String[] args) {
        GraphWithAdjMatrix graphWithAdjMatrix = new GraphWithAdjMatrix(9);
        graphWithAdjMatrix.addEdge(0,1,4);
        graphWithAdjMatrix.addEdge(0,7,8);
        graphWithAdjMatrix.addEdge(1,2,8);
        graphWithAdjMatrix.addEdge(1,7,11);
        graphWithAdjMatrix.addEdge(2,3,7);
        graphWithAdjMatrix.addEdge(2,8,2);
        graphWithAdjMatrix.addEdge(2,5,4);
        graphWithAdjMatrix.addEdge(3,4,9);
        graphWithAdjMatrix.addEdge(3,5,14);
        graphWithAdjMatrix.addEdge(4,5,10);
        graphWithAdjMatrix.addEdge(5,6,2);
        graphWithAdjMatrix.addEdge(6,7,1);
        graphWithAdjMatrix.addEdge(6,8,6);
        graphWithAdjMatrix.addEdge(7,8,7);
        graphWithAdjMatrix.display();
        dijkstra(graphWithAdjMatrix.getGraph(),2);

    }

}
