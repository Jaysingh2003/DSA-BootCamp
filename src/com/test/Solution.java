package com.test;

import java.util.*;

public class Solution {
    public static int getMaxLoad(List<Integer> price, List<Integer> load, int max_price) {
        int n = price.size();
        int maxLoad = -1; // Change: initialize to -1

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int total_price = price.get(i) + price.get(j);
                if (total_price <= max_price) {
                    int total_load = load.get(i) + load.get(j);
                    if (total_load > maxLoad) {
                        maxLoad = total_load;
                    }
                }
            }
        }

        return maxLoad; // Will return -1 if no valid pair found
    }

    public static void main(String[] args) {
        List<Integer> price = Arrays.asList(1,2,3,5,4);
        List<Integer> load = Arrays.asList(1,2,3,4,6);
        int max_price = 8;
        System.out.println(getMaxLoad(price, load, max_price)); // Output: 10
    }
}