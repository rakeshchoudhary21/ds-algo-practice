package com.ds.graphs.algos.known;

import com.ds.graphs.algos.GraphWithAdjMatrix;

import java.util.Stack;

import static com.ds.graphs.algos.known.ConnectedOrNot.isConnected;

public class EulerCircuit {

    /**
     * The Euler Cicuit visits each edge of graph exactly once. Closed Euler path is the one that start and end
     * at the same vertex.
     *
     * A Euleran Graph is the one that contains Euler Cycle.
     *
     * For Euler Path to exist you need exactly 2 vertices with odd in degree or zero with odd in degree.
     * For Euler Circuit you need all vertices to have even degree
     *
     * To Find the euler Path we should start with first odd degree vertex or if no such vertex then any random vertex.
     */


    /**
     *
     * @param graph adj matrix of graph
     * @return Returns 0 for Non Eulerian, 1 for Eulerian Circuit and 2 for Eulerian Path
     */
    public static int isEulerian(int[][] graph){
        if(!isConnected(graph)) return 0; //Not Eulerian

        int odd=0;
        for (int i=0;i<graph.length;i++) {
            int degree = 0;
            for (int av = 0; av < graph[i].length; av++) {
                if (graph[i][av] > 0 && av!=i) degree++;
            }
            if(degree%2 !=0 ) odd++;
        }

        if(odd>2) return 0; // Not Eulerian
        return (odd==0) ? 2 : 1;
    }

    /**
     *
     * @param graph adj matrix of graph
     * @return first odd degree vertex, if none exist then simply return zero
     */
    private static int findFirstVertextToTraverse(int[][] graph){
        for(int i=0;i<graph.length;i++){
            int degree=0;
            for(int av=0;av<graph[i].length;av++){
                if(av!=i && graph[i][av]>0) degree++;
            }
            if(degree%2 !=0 ) return i;
        }
        return 0;
    }

    /**
     *
     * @param graph adj matrix of graph
     * @param startingVertex vertex at which euler cycle begins
     */
    public static void printEulerCycle(int[][] graph, int startingVertex) {
        for(int av=0;av<graph[startingVertex].length;av++){
            if(av!=startingVertex && graph[startingVertex][av]>0 && isValidNextEdge(graph,startingVertex,av)){
                System.out.print(startingVertex+"->"+av+"\t");
                removeEdge(graph,startingVertex,av); //remove edge
                printEulerCycle(graph,av);
            }
        }
    }

    /**
     *
     * @param graph adj matrix of graph
     * @param u source
     * @param v dest
     * @return edge from u to v is valid if v is only neighbor of u or if its a bridge edge
     */
    private static boolean isValidNextEdge(int[][] graph, int u, int v) {
        int remainingNeigbors = 0;
        for(int av=0;av<graph[u].length;av++){
            if(av!=u && graph[u][av]>0) remainingNeigbors++;
        }

        if(remainingNeigbors==0) return false;

        if(remainingNeigbors==1) return true;

        //check if its bridge edge
        boolean[] visited = new boolean[graph.length];
        //check how many vertices we can reach from u
        int count1 = dfsCount(graph,u);
        removeEdge(graph,u,v);
        //remove the edge and check count now
        int count2 = dfsCount(graph,u);
        //add the edge back to graph
        addEdge(graph,u,v);
        //If count 1 is more than count 2 means, removing this edge will disconnect the graph so we return false for that. else its valid edge
        return count1 <= count2;
    }

    private static void addEdge(int[][] graph, int u, int v) {
        graph[u][v]=1;
        graph[v][u]=1;
    }

    private static void removeEdge(int[][] graph, int u, int av) {
        graph[u][av]=0;
        graph[av][u]=0;
    }

    /**
     *  DFS traversal to find number of reachable vertices from source
     * @param graph adj matrix of graph
     * @param u source
     * @return dest
     */
    private static int dfsCount(int[][] graph, int u) {
        int verticesReachable = 0;
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.length];
        stack.push(u);
        visited[u]=true;
        while (!stack.isEmpty()){
            int node = stack.pop();
            for(int av=0;av<graph[node].length;av++){
                if(av!=node && !visited[av]){
                    visited[av]=true;
                    verticesReachable++;
                    stack.push(av);
                }
            }
        }
        return verticesReachable;
    }

    public static void main(String[] args) {
        GraphWithAdjMatrix graph = new GraphWithAdjMatrix(5);
        graph.addEdge(0,1,1);
        graph.addEdge(0,2,1);
        graph.addEdge(0,3,1);
        graph.addEdge(0,4,1);
        graph.addEdge(0,1,1);
        graph.addEdge(1,2,1);
        graph.addEdge(3,4,1);

        System.out.println(isEulerian(graph.getGraph()));
        int startingVertex = findFirstVertextToTraverse(graph.getGraph());
        System.out.println("Starting vertex is:"+startingVertex);
        printEulerCycle(graph.getGraph(),startingVertex);

    }
}
