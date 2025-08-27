package com.test;

import java.util.Arrays;
import java.util.List;

public class Sol2 {

    public static void main(String[] args) {
        List<Integer> products = Arrays.asList(1, 0, 1, 0, 1);
        int k = 3;
        System.out.println(getMinimumCost(products, k)); // Outputs 3


    }

    public static long getMinimumCost(List<Integer> product, int k) {
        int n = product.size();
        long cost = 0;
        // Turn product into a modifiable array
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) arr[i] = product.get(i);

        for (int i = 0; i < n; ++i) {
            // If current is 1, need to zero it
            if (arr[i] == 1) {
                // Find best window covering i
                int l = Math.max(0, i - k + 1);
                int r = Math.min(n - k, i); // allows full window
                long minWindowCost = Long.MAX_VALUE;
                int bestStart = l;
                for (int start = l; start <= r; ++start) {
                    long windowCost = 0;
                    for (int j = start; j < start + k; ++j)
                        windowCost += arr[j];
                    if (windowCost < minWindowCost) {
                        minWindowCost = windowCost;
                        bestStart = start;
                    }
                }
                cost += minWindowCost;
                // Zero this element (i)
                arr[i] = 0;
            }
        }
        return cost;
    }

}
