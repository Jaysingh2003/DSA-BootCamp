
        package com.test;

import java.util.*;

class Result {
    public static void main(String[] args) {
        List<Integer> products = Arrays.asList(1, 1, 0, 1);
        int k = 3;
        System.out.println(getMinimumCost(products, k)); // Outputs 3
    }

    // Greedy with Sliding Window
    public static long getMinimumCost(List<Integer> product, int k) {
        int n = product.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = product.get(i);
        }

        long totalCost = 0;

        // Continue until all elements are 0
        while (hasOnes(arr)) {
            int minCost = Integer.MAX_VALUE;
            int bestStart = -1;
            int bestConvertIdx = -1;

            // Try all possible windows of size k
            for (int i = 0; i <= n - k; i++) {
                int windowSum = 0;
                List<Integer> onesInWindow = new ArrayList<>();

                // Calculate sum and find all 1s in current window
                for (int j = i; j < i + k; j++) {
                    windowSum += arr[j];
                    if (arr[j] == 1) {
                        onesInWindow.add(j);
                    }
                }

                // If window has 1s and cost is better
                if (!onesInWindow.isEmpty() && windowSum < minCost) {
                    minCost = windowSum;
                    bestStart = i;
                    // Convert the first 1 in this window
                    bestConvertIdx = onesInWindow.get(0);
                }
            }

            if (bestStart == -1) break; // Safety check

            // Convert the selected 1 to 0
            arr[bestConvertIdx] = 0;
            totalCost += minCost;
        }

        return totalCost;
    }

    // Helper method to check if array contains any 1s
    private static boolean hasOnes(int[] arr) {
        for (int num : arr) {
            if (num == 1) return true;
        }
        return false;
    }
}