package com.operators;

public class UniqueNumber {
    public static int findUnique(int[] arr) {
        int result = 0;

        // Loop through all 32 bits
        for (int i = 0; i < 32; i++) {
            int sum = 0;

            // Count number of 1s at ith bit
            for (int num : arr) {
                if ((num & (1 << i)) != 0) {
                    sum++;
                }
            }

            // If sum % 3 != 0, that bit belongs to unique number
            if (sum % 3 != 0) {     	//	|= means bitwise OR assignment.and
                result |= (1 << i);     //This sets the ith bit of result to 1 if sum % 3 != 0.
                                        //note Or operation karne par  same digit ati h its like " result = result | (1 << i);"
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {6, 6, 6, 13, 13, 13, 7, 7, 7, 42}; // 42 is unique
        System.out.println(findUnique(arr)); // Output: 42
    }
}