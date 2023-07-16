package com.ds.graphs.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Simple graph impl
 */
public class GraphWithAdjMatrix {


    private int SIZE;
    private int[][] graph;
    private List<List<Integer>> edges;

    private GraphWithAdjMatrix(){}

    public GraphWithAdjMatrix(int size){
        this.SIZE=size;
        this.graph = new int[size][size];
        this.edges = new ArrayList<>();
    }

    public void addEdge(int src,int dest,int cost){
        this.graph[src][dest]=cost;
        this.graph[dest][src]=cost;
        this.edges.add(Arrays.asList(src,dest,cost));
    }

    public void removeEdge(int src,int dest){
        this.graph[src][dest]=0;
    }

    public void display(){
        for(int i=0;i<graph.length;i++){
            System.out.println(i+"->"+ Arrays.toString(this.graph[i]));
        }
    }

    public int[][] getGraph() {
        return graph;
    }

    public List<List<Integer>> getEdges() {
        return edges;
    }


}
