package com.FamousQuestions;

public class Even_Odd_Count {

    // Function to count even numbers in an array
    public static int evenCount(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    // Function to count odd numbers in an array
    public static int oddCount(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    //even and odd bot h count function
    public static int[] evenOddCount(int[] arr) {
        int evenCount = 0;
        int oddCount = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }


        }
        return new int[]{evenCount, oddCount};
    }
}
