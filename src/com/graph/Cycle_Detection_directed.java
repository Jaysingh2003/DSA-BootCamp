package com.graph;

import java.util.ArrayList;

public class Cycle_Detection_directed {

    public class Graph {
        int V;
        ArrayList<ArrayList<Integer>> adj;

        Graph(int V) {
            this.V = V;
            this.adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v) {
            adj.get(u).add(v); // directed graph
        }
    }

    /// We pass the graoph as parameter because Graph is inner class
    public boolean isCyclic(Graph graph) {
        boolean[] visited = new boolean[graph.V];
        boolean[] recPath = new boolean[graph.V];

        for (int i = 0; i < graph.V; i++) {/// for disconnected components, if there is any other loop in the graph
            if (!visited[i]) {
                if (hasCycle(graph, i, visited, recPath)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycle(Graph graph, int curr, boolean[] visited, boolean[] recPath) {

        /// the recPath array keeps track of the nodes in the current recursion stack.
        visited[curr] = true;
        recPath[curr] = true;

        for (int neigh : graph.adj.get(curr)) {
            if (!visited[neigh]) {
                if (hasCycle(graph, neigh, visited, recPath)) {
                    return true;
                }
            }
            /// it is else condition it means if visited[neigh] is true and the node is also in the recPath then it is a back edge
            else if (recPath[neigh]) {// back edge found so cycle exists
                return true; // back edge found
            }
        }

        recPath[curr] = false; // backtrack - remove the node from the recursion stack
        return false;// no cycle found from this path
    }
}