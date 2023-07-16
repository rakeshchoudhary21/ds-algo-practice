package com.ds.graphs.algos.known;

import com.ds.graphs.algos.GraphWithAdjMatrix;

import java.util.LinkedHashSet;
import java.util.Set;

public class HamiltonianCircuit {

    /**
     *
     *  A path thru a graph that visits each vertex exactly once, and last vertex connects back to first.
     *  Hamiltonian path is minus the last edge that connects the last vertex to first one.
     *  This is essentially DFS to reach start node back
     *
     * @param graph adj matrix of graph
     * @param v start vertex
     * @param path path of hamilotnion cycle
     * @param visited visited nodes
     * @return whether a cycle exists
     */
    public static boolean hamiltonianCycleExists(int[][] graph, int v,Set<Integer> path, boolean[] visited) {
        if(path.size() == graph.length) return true;
        for(int i=0;i<graph[v].length;i++){
            if(graph[v][i]!=0 && !visited[i]){
                visited[i]=true;
                path.add(i);
                if(hamiltonianCycleExists(graph,i,path,visited)) return true;
                path.remove(i);
                visited[i]=false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GraphWithAdjMatrix graph = new GraphWithAdjMatrix(7);
        graph.addEdge(0,1,1);
        graph.addEdge(0,3,1);
        graph.addEdge(0,4,1);
        graph.addEdge(0,5,1);
        graph.addEdge(5,1,1);
        graph.addEdge(1,2,1);
        graph.addEdge(1,4,1);
        graph.addEdge(4,2,1);
        graph.addEdge(4,3,1);
        graph.addEdge(2,3,1);
        graph.addEdge(2,6,1);
        graph.addEdge(3,6,1);
        LinkedHashSet<Integer> path = new LinkedHashSet<>();
        boolean[] visited = new boolean[7];
        path.add(0);
        visited[0]=true;
        System.out.println(hamiltonianCycleExists(graph.getGraph(),0,path,visited));
        System.out.println(path);

    }
}
