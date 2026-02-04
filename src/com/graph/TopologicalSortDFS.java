package com.graph;

import java.util.*;

class TopologicalSortDFS {

    static class Graph {
        int V;
        ArrayList<ArrayList<Integer>> adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        // add directed edge u -> v
        void addEdge(int u, int v) {
            adj.get(u).add(v);
        }

        // DFS function
        void dfs(int node, boolean[] visited, Stack<Integer> stack) {
            visited[node] = true;

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    dfs(neighbor, visited, stack);
                }
            }

            // push AFTER visiting all neighbors
            stack.push(node);
        }

        // Topological Sort
        void topologicalSort() {
            boolean[] visited = new boolean[V];
            Stack<Integer> stack = new Stack<>();

            // handle disconnected graph
            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    dfs(i, visited, stack);
                }
            }

            // print result
            while (!stack.isEmpty()) {/// pop from stack to get topological order
                System.out.print(stack.pop() + " ");
            }
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph(6);

        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Topological Sort:");
        g.topologicalSort();
    }
}