package com.ds.graphs.algos.known;

import com.ds.graphs.algos.GraphWithAdjMatrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GraphColoring {
    // color the vertices of a graph such that no two adjacent vertices are colored the same
    /**
     * Problems:
     * 1. Can a graph be colored with given set of colors.
     * 2. How many ways can the graph be colored with given set of colors.
     * 3. Find number of colors required to color a given graph.
     */

    /**Problem 1:
     * Can a graph be colored with given set of colors
     * input: graph, and set of colors m
     * @return true/false
     */
    public static boolean problem1(int[][] graph,int v,int m,int[] colors){
        if(v== graph.length) return true;
        for(int c=1;c<=m;c++){
            if(isValid(graph,c,v,colors)){
                colors[v]=c;
                if(problem1(graph,v+1,m,colors)) return true;
                colors[v]=0;
            }
        }
        return false;
    }

    private static boolean isValid(int[][] graph,int c,int v,int[] colors){
        int[] neighbors = graph[v];
        for(int i=0;i<neighbors.length;i++){
            if(neighbors[i]==1 && colors[i]==c){
                return false;
            }
        }
        return true;
    }

    /**
     * Problem 2: Number of ways to color a graph using given colors
     * @param graph adj matrix of graph
     * @param v start vertex
     * @param m number of colors
     * @param colors allotment of colors
     */
    public static void problem2(int[][] graph,int v,int m,int[] colors){
        if(v== graph.length){
            System.out.println(Arrays.toString(colors));
            return;
        }
        for(int c=1;c<=m;c++){
            if(isValid(graph,c,v,colors)){
                colors[v]=c;
                problem2(graph,v+1,m,colors);
                colors[v]=0;
            }
        }
    }

    /**
     * Problem 3: Minimum number of colors needed to color a graph
     * @param graph matrix
     */

    public static int problem3(int[][] graph){
        int V = graph.length;
        Map<Integer,Integer> color = new HashMap<>();
        color.put(0,1);
        boolean[] alreadyAssigned = new boolean[V];
        for(int u=1;u<V;u++){
            Arrays.fill(alreadyAssigned,false);
            for(int av=0;av<graph[u].length;av++){
                if(graph[u][av]==1 && color.containsKey(av)) alreadyAssigned[color.get(av)]=true;
            }
            int c;
            for(c=1;c<=V;c++) if(alreadyAssigned[c]==false) break;

            color.put(u,c);
        }

        System.out.println(color);
        return color.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
    }

    public static void main(String[] args) {
        GraphWithAdjMatrix graph = new GraphWithAdjMatrix(5);
        graph.addEdge(0, 1,1);
        graph.addEdge(0, 2,1);
        graph.addEdge(1, 2,1);
        graph.addEdge(1, 3,1);
        graph.addEdge(2, 3,1);
        graph.addEdge(3, 4,1);
        System.out.println(problem1(graph.getGraph(),0,3,new int[graph.getGraph().length]));
        problem2(graph.getGraph(),0,3,new int[graph.getGraph().length]);
        System.out.println(problem3(graph.getGraph()));

    }
}
