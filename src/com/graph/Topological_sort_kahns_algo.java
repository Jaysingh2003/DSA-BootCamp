package com.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Topological_sort_kahns_algo {
    class Graph {
        private int V; // Number of vertices
        List<List<Integer>> adj; // Adjacency list representation

        // Constructor
        public Graph(int V, List<List<Integer>> adj) {
            this.V = V;
            this.adj = adj;
        }

    }

    public static List<Integer> topoSort(int V, List<List<Integer>> adj) {

        List<Integer> result = new LinkedList<>();
        ///calculate indegree
        int[] indegree = new int[V];
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }
        /// Initialize queue with all vertices having indegree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        for (int i = 0; i < V; i++) {
            // Remove vertex from queue
            int u = q.poll();
            result.add(u);///store the topological order
            // Reduce indegree of adjacent vertices
            for (int v : adj.get(u)) {
                indegree[v]--;
                // If indegree becomes 0, add it to queue
                if (indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
        // if we have to check there is cycle or not it is used when we have no idea abou the graph
        if (result.size() != V) {
            System.out.println("Graph has a cycle, topological sort not possible");
        }
        return result;


    }
}
