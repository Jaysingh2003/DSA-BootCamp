package com;

import java.util.ArrayList;

class Solution {

    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        // Build adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (ArrayList<Integer> edge : Edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Try starting DFS from every node
        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            if (dfs(i, visited, 1, graph, N)) {
                return true; // Hamiltonian path found
            }
        }
        return false; // No Hamiltonian path
    }

    boolean dfs(int node, boolean[] visited, int count,
                ArrayList<ArrayList<Integer>> graph, int N) {

        visited[node] = true;

        // If all nodes are visited
        if (count == N) {
            return true;
        }
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, visited, count + 1, graph, N)) {
                    return true;
                }
            }
        }
        // Backtrack
        visited[node] = false;
        return false;
    }

}