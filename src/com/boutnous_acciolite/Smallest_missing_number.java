package com.boutnous_acciolite;

/// https://www.geeksforgeeks.org/problems/smallest-positive-missing-number-1587115621/1
public class Smallest_missing_number {
//    The smallest missing positive number is always in the range 1 to n + 1,
//    where n is the size of the array.

    public static int smallestMissingPositive(int[] arr) {
        int n = arr.length;

        // Step 1-> Ignore useless values
        //beacause negative no se or zero se hume koi fayda nhi hoga and //also greater than n  because smallest missing positive no n+1 se jyada nhi ho skta
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = n + 1;
            }
        }

        // Step 2 mark index v-1 as negative if v is present in the array -ve mark se hame extra space nhi lgana pdta
        for (int i = 0; i < n; i++) {
            int val = Math.abs(arr[i]);
            if (val <= n) {
                arr[val - 1] = -Math.abs(arr[val - 1]);
            }
        }

        // Step 3 find the first index which is positive and return index + 1 as the answer
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
