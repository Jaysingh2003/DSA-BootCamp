package com.graph;

import java.util.ArrayList;
import java.util.List;

public class DFS_Graph_traversal {

    class Graph {
        int V;
        List<List<Integer>> adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u); // remove for directed graph
        }

        void dfs(int start) {
            boolean[] visited = new boolean[V];
            dfsHelper(start, visited);
        }

        /// core dfs logic
        /// u = current node
        /// in the dfs we mark the current node as visited and then explore all its unvisited neighbors recursively
        void dfsHelper(int u, boolean[] visited) {
            visited[u] = true;
            System.out.print(u + " ");

            for (int v : adj.get(u)) {/// adj.get(u) = immediate neighbors of u
                if (!visited[v]) {
                    dfsHelper(v, visited);// v become the source node-> Recursive call to explore deeper
                }
            }
        }

        //id there are the dissconnected components in the graph
        void dfsDisconnected() {
            boolean[] visited = new boolean[V];

            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    dfsHelper(i, visited);
                    System.out.println(); // separates components
                }
            }
        }
    }
}
