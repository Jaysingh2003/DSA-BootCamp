package com.graph;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/// digkstra's Algorithm is a greedy algorithm that solves the single-source shortest path problem,
/// it finds the shortest path from a source node to all other nodes in a weighted graph with non-negative weights.
public class Dijkstra_Algorithm {

    class Pair {
        int dist;
        int node;

        Pair(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }
    }

    public int[] dijkstraAlgorithm(int V, List<List<Pair>> adj, int source) {

        // Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);// Infinity distance intially

        // Source distance is 0
        dist[source] = 0;

        // Min heap based on distance
        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));

        // Add source node in priority queue initially
        pq.offer(new Pair(0, source));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();// Get node with minimum distance first
            int u = curr.node;
            int currDist = curr.dist;

            // Skip outdated entries means the current distance is greater than recorded distance like priviosu waight ko updata karna ah ki nahi
            if (currDist > dist[u]) continue;

            // Relax adjacent edgesm,means update distance if smaller distance found
            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.node;
                int weight = neighbor.dist;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new Pair(dist[v], v));// Add updated distance to priority queue
                }
            }
        }
        return dist;
    }
}