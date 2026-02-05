package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public  class Bellman_Ford {

    // Edge class (represents u -> v with weight)
    /// u ──(weight)──> v
    static class Edge {
        int u;
        int v;
        int weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    public void bellmanFord(int V, List<Edge> edges, int source) {
      /// Stores shortest distance
        int[] dist = new int[V];

        // Step 1: Set all distances to infinity
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;// Distance to source is 0

        // Step 2: Relax edges V - 1 times means v-i times the loop chalega
        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : edges) {
                int u = edge.u;
                int v = edge.v;
                int wt = edge.weight;

                if (dist[u] != Integer.MAX_VALUE &&
                        dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

//           if in interviuew it say detect a cycle in the -ve wightted graph->  Yes, we use Bellman–Ford.
//                After relaxing edges V−1 times, we do one more pass.
//                If any distance still decreases, a negative weight cycle exists.
        /// it will not reqired in the id the intervuew not ask for negative weight cycle detection
        // Step 3: Check for negative weight cycle
        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;
            int wt = edge.weight;

            if (dist[u] != Integer.MAX_VALUE &&
                    dist[u] + wt < dist[v]) {
                System.out.println("Negative weight cycle detected");
                return;
            }
        }

        // Print distances
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "        " + dist[i]);
        }
    }

    /// u ──(weight)──> v

    public static void main(String[] args) {

        Bellman_Ford bf = new Bellman_Ford();

        int V = 5;
        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(1, 2, -4));
        edges.add(new Edge(2, 3, 2));
        edges.add(new Edge(3, 4, 4));
        edges.add(new Edge(0, 3, 0));
        edges.add(new Edge(0, 4, 1));

        bf.bellmanFord(V, edges, 0);
    }
}