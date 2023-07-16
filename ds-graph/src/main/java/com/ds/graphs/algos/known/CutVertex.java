package com.ds.graphs.algos.known;

import com.ds.graphs.algos.GraphWithAdjMatrix;

import java.util.*;

public class CutVertex {
    //Tarzan's algo:: Articulation point ::: Cut Vertex ::

    //A point is called AP if removing it and all edges from it will increase the number of connected components in graph.

    //basically removing the node creates more than 2 connected components, just 2 connected components is not AP.

    //Brute Force:
    /**
     * For each v in V
     *  remove v from graph
     *  if graph not connected any more than result++
     *
     *  isConnected: graph
     *  this can be done with BFS or DFS.
     *  at the end just check if visited all vertices.

     * A vertex u can be AP if it's not root or leaf in DFS tree,
     * and it has a child v such that no vertex in subtree of v is connected to ancestor v via a back-edge.
     * back-edge: an edge that is not in DFS tree but present in the original graph.

     * Tarzan's Algo:
     * 1. Compute Discovery time for all nodes:  just a number we assign to each node denoting order of discovery in DFS. root is 1, its children 2 or 3 and so on.
     * 2. Compute low time: low[u] = min(disc[u], disc[w], low[v]) => disc[u] disc time of u, disc[w] disc time of back edge from u, low[v] low of children of u.
     */

    Set<Integer> result;
    boolean[] visited;
    int[] disc;
    int[] low;
    int[] parent;
    int time = 0;

    public CutVertex(int SIZE){
        this.result = new HashSet<>();
        this.visited = new boolean[SIZE];
        this.disc = new int[SIZE];
        this.low = new int[SIZE];
        this.parent = new int[SIZE];
        Arrays.fill(this.parent,Integer.MAX_VALUE);
    }

    public void findAP(int[][] graph, int v){
        visited[v] = true;
        time++;
        low[v] = disc[v] = time;
        int child = 0;
        for(int i=0;i<graph[v].length;i++){
            if(graph[v][i]!=0){
                if(visited[i]==false){
                    child+=1;
                    parent[i]=v;
                    findAP(graph,i);
                    low[v] = Math.min(low[v],low[i]);
                    if(parent[v] == Integer.MAX_VALUE && child > 1)
                        result.add(v);
                    else if(parent[v] != Integer.MAX_VALUE && low[i]>=disc[v])
                        result.add(v);
                }else if(i != parent[v]) //back edge: has an edge but not direct parent.
                    low[v] = Math.min(low[v],disc[i]);
            }
        }
    }

    public static void main(String[] args) {
        CutVertex cutVertex = new CutVertex(5);
        GraphWithAdjMatrix g1 = new GraphWithAdjMatrix(5);

        g1.addEdge(1, 0,1);
        g1.addEdge(0, 2,1);
        g1.addEdge(2, 1,1);
        g1.addEdge(0, 3,1);
        g1.addEdge(3, 4,1);
        cutVertex.findAP(g1.getGraph(),0);
        System.out.println(cutVertex.result);

        CutVertex cutVertex2 = new CutVertex(3);
        GraphWithAdjMatrix g2 = new GraphWithAdjMatrix(3);
        g2.addEdge(0, 1,1);
        g2.addEdge(2, 1,1);
        cutVertex2.findAP(g2.getGraph(),0);
        System.out.println(cutVertex2.result);
    }

}
