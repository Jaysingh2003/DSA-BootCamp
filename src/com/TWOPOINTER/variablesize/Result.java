// File: `src/com/TWOPOINTER/variablesize/Result.java`
package com.TWOPOINTER.variablesize;

import java.util.*;

public class Result {

    public static int getMinimumCost(List<Integer> arr) {
        int n = arr.size();
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int v = arr.get(i);
            first.putIfAbsent(v, i);
            last.put(v, i);
        }

        int cost = 0;
        int i = 0;
        while (i < n) {
            int v = arr.get(i);
            if (first.get(v) == i && last.get(v) > i) {
                int curR = last.get(v);
                Set<Integer> distinct = new HashSet<>();
                for (int j = i; j <= curR; j++) {
                    int w = arr.get(j);
                    distinct.add(w);
                    curR = Math.max(curR, last.get(w));
                }
                cost += distinct.size();
                i = curR + 1;
            } else {
                i++;
            }
        }

        return cost;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(12, 3, 15, 5, 10, 11, 4, 16, 16, 1, 2, 11, 5);
        List<Integer> arr1 = Arrays.asList(6, 1, 2, 3, 2, 1, 4);
        List<Integer> arr2 = Arrays.asList(4, 2, 7, 4, 7);
        List<Integer> arr3 = Arrays.asList(4, 7, 4, 7);

        System.out.println(getMinimumCost(arr));
        System.out.println(getMinimumCost(arr1));
        System.out.println(getMinimumCost(arr2));
        System.out.println(getMinimumCost(arr3));
    }
}
