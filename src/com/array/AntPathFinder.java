package com.array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


    public class AntPathFinder {

        public static int antsteps(int[] prohibited, int[] data) {
            int a = data[0];
            int b = data[1];
            int x = data[2];

            Set<Integer> blocked = new HashSet<>();
            for (int p : prohibited) {
                blocked.add(p);
            }

            boolean[][] visited = new boolean[20001][2];

            Queue<int[]> queue = new LinkedList<>();

            queue.add(new int[]{0, 0, 0});
            visited[0][0] = true;

            int upperBound = Math.max(12000, x + a + b);

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int pos = current[0];
                int steps = current[1];
                int lastWasBackward = current[2];

                if (pos == x) return steps;

                int forwardPos = pos + a;
                if (forwardPos <= upperBound && !blocked.contains(forwardPos) && !visited[forwardPos][0]) {
                    visited[forwardPos][0] = true;
                    queue.add(new int[]{forwardPos, steps + 1, 0});
                }

                if (lastWasBackward == 0) {
                    int backwardPos = pos - b;
                    if (backwardPos >= 0 && !blocked.contains(backwardPos) && !visited[backwardPos][1]) {
                        visited[backwardPos][1] = true;
                        queue.add(new int[]{backwardPos, steps + 1, 1});
                    }
                }
            }

            return -1;
        }

        public static void main(String[] args) {
            int[] prohibited = {14, 4, 18, 1, 15};
            int[] data = {3, 15, 9};
            System.out.println(antsteps(prohibited, data));
        }
    }
