package com.TWOPOINTER.variablesize;


//// This code implements a solution to find the maximum sum of a circular subarray in an array of integers.
///  The algorithm uses a combination of the standard Kadane's algorithm to find the maximum sum of
///  a non-circular subarray and a modified version to find the minimum sum subarray.
/// The maximum circular subarray sum is then calculated by subtracting the minimum subarray sum from the total sum of the array.
///  Finally, the algorithm returns the maximum of the two cases (circular and non-circular) as the result.
/// complxity is O(n) and space complexity is O(1)
public class Maximum_Sum_Circular_Subarray {

    // ----------------------------
    // 1️⃣ Normal Kadane Algorithm
    // Finds maximum sum subarray (non-circular case)
    // ----------------------------
    int kadane(int[] arr) {

        int max = Integer.MIN_VALUE;  // stores global maximum
        int currentSum = 0;           // stores current subarray sum

        for (int i = 0; i < arr.length; i++) {

            currentSum += arr[i];     // extend current subarray

            // update global maximum if needed
            max = Math.max(max, currentSum);

            // if current sum becomes negative,
            // it cannot help in future → reset
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return max;
    }

    // ----------------------------
    // 2️⃣ Minimum Kadane Algorithm
    // Finds minimum sum subarray
    // Used for circular case
    // ----------------------------
    int minKadane(int[] arr) {

        int min = Integer.MAX_VALUE;  // stores global minimum
        int currentSum = 0;           // stores current subarray sum

        for (int i = 0; i < arr.length; i++) {

            currentSum += arr[i];     // extend current subarray

            // update global minimum if needed
            min = Math.min(min, currentSum);

            // if current sum becomes positive,
            // it cannot help in forming smaller sum → reset
            if (currentSum > 0) {
                currentSum = 0;
            }
        }

        return min;
    }

    // ----------------------------
    // 3️⃣ Main Function
    // Computes Maximum Circular Subarray Sum
    // ----------------------------
    public int maxSubarraySumCircular(int[] arr) {

        /// Step 1: Find normal maximum subarray sum
        int maxNormal = kadane(arr);

        // If all elements are negative,
        // circular logic will fail → return normal max
        if (maxNormal < 0) {
            return maxNormal;
        }

        /// Step 2: Calculate total sum of array
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        /// Step 3: Find minimum subarray sum
        int minSub = minKadane(arr);

        /// Step 4: Calculate circular maximum
        // Circular max = total sum - minimum subarray
        int maxCircular = totalSum - minSub;

        /// Step 5: Return maximum of both cases
        return Math.max(maxNormal, maxCircular);
    }
}