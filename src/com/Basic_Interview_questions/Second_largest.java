package com.Basic_Interview_questions;

/// this cod is work file in thiwswe scanrio
 /// {10, 5, 20, 8} / {5, 5, 5}/ {-1, -2, -3}  /{Integer.MIN_VALUE, 5, 3}

public class Second_largest {
    public static int secondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        boolean foundSecond = false;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
                foundSecond = true;
            }
            else if (num < largest && num > secondLargest) {
                secondLargest = num;
                foundSecond = true;
            }
        }

        if (!foundSecond) {
            throw new IllegalArgumentException("No second largest element");
        }

        return secondLargest;
    }

}
