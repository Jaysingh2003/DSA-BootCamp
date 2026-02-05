package com.graph;

import java.util.ArrayList;

public class Cycle_Detection_Indirected {

    static class Graph {
        int V;  // number of vertices
        ArrayList<ArrayList<Integer>> adj; // adjacency list

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        // Adds an undirected edge between u and v
        void addEdge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Handles disconnected graphs
        boolean hasCycle() {
            boolean[] visited = new boolean[V];

            for (int i = 0; i < V; i++) {/// for disconnected components
                if (!visited[i]) {
                    if (dfs(i, -1, visited))/// -1 means no parent for the starting node
                        return true;/// if cycle found in any component, return true
                }
            }
            return false;/// no cycles found in any component
        }

        // DFS with parent tracking to detect cycle
        boolean dfs(int node, int parent, boolean[] visited) {
            visited[node] = true;

            for (int neigh : adj.get(node)) {
                if (!visited[neigh]) {
                    if (dfs(neigh, node, visited))
                        return true;///if cycle found in the recursive call, means ki in future call cycle mil gya to true return kar do
                }
                // visited neighbor not equal to parent ⇒ cycle
                else if (neigh != parent) {
                    return true;
                }
            }
            return false;
        }
    }
}