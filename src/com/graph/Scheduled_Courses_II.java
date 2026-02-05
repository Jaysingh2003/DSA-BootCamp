package com.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/// https://leetcode.com/problems/course-schedule-ii/description/
public class Scheduled_Courses_II {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Goal: return an order of courses you can take so that
        // all prerequisites are satisfied.
        // If it's impossible (because of a cycle), return an empty array.

        // 1) Build the graph (adjacency list).
        // We store: for each course, which courses depend on it.
        // Example: [a, b] means: to take course 'a' you must first take 'b'
        // So the directed edge is: b -> a
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges according to prerequisites
        for (int[] p : prerequisites) {
            // p[1] must come before p[0]
            adj.get(p[1]).add(p[0]);
        }

        // visited[i]  : have we fully started processing course i at least once?
        // recStack[i] : is course i currently in the SAME DFS path (call stack)?
        //               If we see a neighbor that is already in recStack,
        //               it means we found a cycle.
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        // We'll push courses AFTER we finish exploring their neighbors.
        // This gives us a "postorder" list.
        List<Integer> result = new ArrayList<>();

        // 2) Run DFS from every node (because the graph can have multiple components).
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                // If dfs returns true => cycle found => no valid ordering
                if (dfs(i, adj, visited, recStack, result)) {
                    return new int[]{};
                }
            }
        }

        // 3) Reverse postorder to get topological order.
        // Because a node is added AFTER its prerequisites chain is explored.
        Collections.reverse(result);

        // Convert List<Integer> -> int[]
        return result.stream().mapToInt(i -> i).toArray();
    }

    // DFS returns true if a cycle exists in the graph.
    // If cycle exists, answer must be an empty array.
    private boolean dfs(int node,
                        ArrayList<ArrayList<Integer>> adj,
                        boolean[] visited,
                        boolean[] recStack,
                        List<Integer> result) {

        // Mark as visited and mark it present in current DFS path
        visited[node] = true;
        recStack[node] = true;

        // Explore all courses that depend on 'node'
        for (int nei : adj.get(node)) {

            // If neighbor not visited, continue DFS
            if (!visited[nei]) {
                if (dfs(nei, adj, visited, recStack, result)) {
                    return true; // cycle found below
                }
            }
            // If neighbor is visited AND still in current recursion path,
            // we found a back-edge => cycle.
            else if (recStack[nei]) {
                return true;
            }
        }

        // We are done exploring this node, remove from current DFS path
        recStack[node] = false;

        // Postorder: add the course AFTER exploring all courses that come after it.
        result.add(node);
        return false;
    }
}