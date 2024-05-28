package com.String;

import java.util.*;

public class getMinimumOperations {
    public int minOperations(int[] items) {

        return Math.min(
                calculate(items, 0), // start with even
                calculate(items, 1)  // start with odd
        );
    }

    private int calculate(int[] items, int startParity) {

        long operations = 0;

        for (int i = 0; i < items.length; i++) {

            int expectedParity = (startParity + i) % 2;
            int value = items[i];
            int count = 0;

            while (value > 0 && value % 2 != expectedParity) {
                value /= 2;
                count++;
            }

            if (value % 2 != expectedParity) {
                return Integer.MAX_VALUE;
            }

            operations += count;
        }

        return (int) operations;
    }


}