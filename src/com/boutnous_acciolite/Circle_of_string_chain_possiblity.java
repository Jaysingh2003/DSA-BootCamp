package com.boutnous_acciolite;


import java.util.ArrayList;
import java.util.List;

/// https://www.geeksforgeeks.org/problems/circle-of-strings4530/1
///  int this question we have to check if we can form a circle with given strings
///  i.e last character of a string should be equal to first character of next string
///  and last character of last string should be equal to first character of first string
public class Circle_of_string_chain_possiblity {

/// in this first we will chck indegree and outdegree of each character
/// if indegree and outdegree of each character is equal then only we will check for connectivity
/// if both conditions are satisfied then we can form a circle
    public class CircleOfStrings {

        static final int ALPHABET = 26;

        public static boolean canFormCircle(String[] arr) {

            int[] in = new int[ALPHABET];
            int[] out = new int[ALPHABET];

            List<List<Integer>> adj = new ArrayList<>();// adjacency list
            for (int i = 0; i < ALPHABET; i++)
                adj.add(new ArrayList<>());

            // Build graph
            for (String s : arr) {
                int u = s.charAt(0) - 'a';
                int v = s.charAt(s.length() - 1) - 'a';

                adj.get(u).add(v);// directed edge from u to v
                out[u]++;// increment outdegree of u
                in[v]++;// increment indegree of v
            }

            // Check indegree == outdegree
            //we will check for each character if its indegree is equal to outdegree
            for (int i = 0; i < ALPHABET; i++) {
                if (in[i] != out[i])
                    return false;
            }

            // Find a vertex with non-zero degree
            //this is used to start DFS be
            int start = -1;
            for (int i = 0; i < ALPHABET; i++) {
                if (out[i] > 0) {
                    start = i;
                    break;
                }
            }

            // If no edges exist
            if (start == -1) return true;

            // Check connectivity
            boolean[] visited = new boolean[ALPHABET];
            dfs(start, adj, visited);
            //this will help to check if the graph  has only one cycle not two differnt clcyces
            /// This character is used in the graph, but DFS could not reach it.”
            for (int i = 0; i < ALPHABET; i++) {
                if ((in[i] > 0 || out[i] > 0) && !visited[i])///(in[i] > 0 || out[i] > 0)-> this character is used in the graph
                    return false;                            ///!visited[i]--> but DFS could not reach it
            }
            return true;
        }
        //  DFS to check connectivity (its core dfs logic)
        private static void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
            visited[node] = true;
            for (int next : adj.get(node)) {
                if (!visited[next])
                    dfs(next, adj, visited);
            }
        }
    }

}
