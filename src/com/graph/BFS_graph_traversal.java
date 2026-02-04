package com.graph;

import java.util.*;

public class BFS_graph_traversal {

    class Graph {
        int V;
        List<List<Integer>> adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();

            // IMPORTANT: initialize adjacency list
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u); // remove for directed graph
        }

        ///  dfs traversal from a given source s
        /// time complexity: O(V + E)
        /// space complexity: O(V)
        ///
        /// Algorithm:
        /// In bfs we asume a queue and a boolean visited array to keep track of visited nodes and similar to the graph we start
        /// from a source node we mark it visited and add it to the queue
        /// then we enter a loop until the queue is empty we remove the front node from the queue
        /// and print it we then explore all its unvisited neighbours mark them visited and add them to the queue
        /// this continues until the queue is empty
        public void traversal() {
            boolean[] visited = new boolean[V];
            Queue<Integer> queue = new LinkedList<>();

            int startNode = 0;
            queue.offer(startNode);//add the starting node to the queue
            visited[startNode] = true;

           ///jab tak queue khali na ho jaye
            while (!queue.isEmpty()) {
                int u = queue.poll();//remove the front node from the queue
                System.out.print(u + " ");

                for (int v : adj.get(u)) {//adjacency list of u which will give all the neighbours of u and we set it manually in the starting
                    if (!visited[v]) {//and  v : adj.get(u)  it means u ke saare neighbour ko travers  karo  one by one
                        visited[v] = true;
                        queue.offer(v);
                    }
                }
            }
        }
    }
}