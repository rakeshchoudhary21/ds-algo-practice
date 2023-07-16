package com.ds.graphs.algos.known;

import com.ds.graphs.algos.GraphWithAdjMatrix;

import java.util.Stack;

public class ConnectedOrNot {

    //just checks if a graph is connected or not.
    public static boolean isConnected(int[][] graph){
        boolean isConnected = true;
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.length];
        stack.push(0);
        visited[0]=true;
        //DFS
        while(stack.isEmpty()==false){
            int curr = stack.pop();
            for(int i=0;i<graph[curr].length;i++){
                if(visited[i]==false && graph[curr][i]!=0){
                    stack.push(i);
                    visited[i]=true;
                }
            }
        }
        for(boolean b: visited)
            if(b==false){
                isConnected=false;
                break;
            }
        return isConnected;
    }

    public static void main(String[] args) {
        GraphWithAdjMatrix graphWithAdjMatrix = new GraphWithAdjMatrix(4);
        graphWithAdjMatrix.addEdge(0,1,4);
        graphWithAdjMatrix.addEdge(0,2,8);
        graphWithAdjMatrix.addEdge(1,2,8);
        graphWithAdjMatrix.addEdge(3,3,11);

        graphWithAdjMatrix.display();

        System.out.println(isConnected(graphWithAdjMatrix.getGraph()));
    }

}
