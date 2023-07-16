package com.ds.graphs.algos.known;

import com.ds.graphs.algos.GraphWithAdjMatrix;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Prims {

    //greedy MST algo, from a give start node find MST in graph
    public static void primsMST(int[][] graph,int start){
        Queue<Pair<Integer,Integer>> pq = new PriorityQueue<>(Comparator.comparing(Pair::getValue));
        pq.offer(Pair.of(start,0));
        boolean[] inMST = new boolean[graph.length];
        Integer[] parent = new Integer[graph.length];
        Arrays.fill(parent,null);
        int[] dist = new int[graph.length];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start]=0;

        while (pq.isEmpty()==false){
            Pair<Integer,Integer> top = pq.poll();
            if(parent[top.getKey()]!=null && inMST[top.getKey()]==false)
                System.out.println(parent[top.getKey()]+"->"+top.getKey()+":"+top.getValue());

            inMST[top.getKey()]=true;
            for(int i=0;i<graph.length;i++)
                if(graph[top.getKey()][i]>0 && inMST[i]==false && dist[i] > graph[top.getKey()][i]){
                    parent[i]=top.getKey();
                    dist[i]=graph[top.getKey()][i];
                    pq.offer(Pair.of(i,dist[i]));
                }
        }
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
        primsMST(graph.getGraph(),0);
    }
}
