package com.graph;

import java.util.ArrayList;
import java.util.List;

public class Undircetd_graph_repersentation {

    class Graph {
        int V;
        List<List<Integer>> adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();

            // create empty list for each vertex
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        // For UNDIRECTED graph
        void addEdge(int u, int v) {
            //.get(u) fetches the list at index u
            adj.get(u).add(v); // u -> v//use it only for directed graph
            //adj.get(v).add(u); ///if undirected graph v -> u
        }
    }


    public static void main(String[] args) {
        Graph g = new Undircetd_graph_repersentation().new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 4);
        g.addEdge(1, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        // Print the adjacency list representation of the graph
        for (int i = 0; i < g.V; i++) {// for each vertex
            System.out.print("Vertex " + i + ":");
            for (Integer neighbor : g.adj.get(i)) {// for each neighbor of vertex i
                System.out.print(" " + neighbor);
            }
            System.out.println();
        }
    }
}