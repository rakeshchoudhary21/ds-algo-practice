package com.ds.graphs.algos.traversals;

import com.ds.graphs.algos.GraphWithAdjMatrix;

import java.util.*;

public class BfsAndDfs {

    public static void bfs(int[][] graph,int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        while(queue.isEmpty()==false){
            int current = queue.poll();
            System.out.println(current);
            for(int i=0;i<graph[current].length;i++){
                if(graph[current][i]==1 && visited.contains(i)==false){
                    //there is an edge
                    queue.offer(i);
                    visited.add(i);
                }
            }
        }
    }

    //Where there is a stack, there can be recursion
    public static void dfs(int[][] graph,int start){
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        while(stack.isEmpty()==false){
            int current = stack.pop();
            System.out.println(current);
            for(int i=0;i<graph[current].length;i++){
                if(graph[current][i]==1 && visited.contains(i)==false){
                    //there is an edge
                    stack.push(i);
                    visited.add(i);
                }
            }
        }
    }

    public static void dfsRec(int[][] graph,int start,Set<Integer> visited){
        visited.add(start);
        System.out.println(start);
        for(int i=0;i<graph[start].length;i++) {
            if (graph[start][i] == 1 && visited.contains(i) == false) {
                //there is an edge
                dfsRec(graph, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        GraphWithAdjMatrix g = new GraphWithAdjMatrix(4);
        g.addEdge(0, 1,1);
        g.addEdge(0, 2,1);
        g.addEdge(1, 2,1);
        g.addEdge(2, 0,1);
        g.addEdge(2, 3,1);
        g.addEdge(3, 3,1);
        g.display();
        bfs(g.getGraph(),2);
        System.out.println("=======================dfs=============");
        GraphWithAdjMatrix graph = new GraphWithAdjMatrix(7);
        graph.addEdge(0, 1,1);
        graph.addEdge(0, 3,1);
        graph.addEdge(1, 2,1);
        graph.addEdge(2, 3,1);
        graph.addEdge(2, 6,1);
        graph.addEdge(3, 4,1);
        graph.addEdge(4, 5,1);
        graph.addEdge(5, 6,1);

        dfs(graph.getGraph(),0);
        System.out.println("=======================dfs(Recursion)=============");
        dfsRec(graph.getGraph(),0,new HashSet<>());
    }
}
