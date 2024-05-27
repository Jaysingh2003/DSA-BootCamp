package com.String;

import java.util.*;

class Solution {
    public int minOperations(int[] items) {
        int n = items.length;

        if (isOrganized(items)) {
            return 0;
        }

        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new State(items.clone(), 0));
        visited.add(arrayToString(items));

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (isOrganized(current.items)) {
                return current.operations;
            }

            // Find positions involved in conflicts
            Set<Integer> conflictPositions = getConflictPositions(current.items);

            // Only halve conflicting positions
            for (int i : conflictPositions) {
                int[] newItems = current.items.clone();
                newItems[i] = newItems[i] / 2;

                String stateStr = arrayToString(newItems);
                if (!visited.contains(stateStr)) {
                    visited.add(stateStr);
                    queue.offer(new State(newItems, current.operations + 1));
                }
            }
        }

        return -1;
    }

    private boolean isOrganized(int[] items) {
        for (int i = 0; i < items.length - 1; i++) {
            if (items[i] % 2 == items[i + 1] % 2) {
                return false;
            }
        }
        return true;
    }

    private Set<Integer> getConflictPositions(int[] items) {
        Set<Integer> conflicts = new HashSet<>();
        for (int i = 0; i < items.length - 1; i++) {
            if (items[i] % 2 == items[i + 1] % 2) {
                conflicts.add(i);
                conflicts.add(i + 1);
            }
        }
        return conflicts;
    }

    private String arrayToString(int[] arr) {
        return Arrays.toString(arr);
    }

    static class State {
        int[] items;
        int operations;

        State(int[] items, int operations) {
            this.items = items;
            this.operations = operations;
        }


        public class Main {
            public static void main(String[] args) {
                Solution sol = new Solution();

                // Example 1: [4, 10, 10, 6, 2]
                int[] items1 = {4, 10, 10, 6, 2};
                System.out.println("Example 1: " + sol.minOperations(items1)); // Expected: 2

                // Example 2: [6, 5, 9, 7, 3]
                int[] items2 = {6, 5, 9, 7, 3};
                System.out.println("Example 2: " + sol.minOperations(items2)); // Expected: 3
            }
        }
    }
}