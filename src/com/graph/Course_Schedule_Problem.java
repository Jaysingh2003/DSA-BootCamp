package com.graph;

import java.util.ArrayList;

/// https://leetcode.com/problems/course-schedule/description/
public class Course_Schedule_Problem {

    // DFS function to detect cycle
    public boolean isCyclic(
            int src,
            boolean[] visited,
            boolean[] recStack,
            ArrayList<ArrayList<Integer>> adj
    ) {

        // mark current node
        visited[src] = true;
        recStack[src] = true;

        // go to all neighbours
        for (int v : adj.get(src)) {

            // if neighbour not visited, DFS
            if (!visited[v]) {
                if (isCyclic(v, visited, recStack, adj)) {/// we will explore the other nodes of that neighbour
                    return true;///if cycle found in any of its neighbour return true
                }
            }
            // if neighbour already in recursion path → cycle
            /// in this case if alredy visited and  also in recStack   that means we have come again to the same node in the same path so cycle
            else if (recStack[v]) {//this is the case if  visited[v] is true
                return true;
            }
        }

        // backtracking: remove from recursion stack
        recStack[src] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // edge: b -> a
        for (int[] p : prerequisites) {
            int a = p[0];
            int b = p[1];
            adj.get(b).add(a);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        // check all components
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (isCyclic(i, visited, recStack, adj)) {
                    return false; // cycle found
                }
            }
        }

        return true; // no cycle
    }
}