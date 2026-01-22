package com.FamousQuestions;

public class Second_Largest {
    public static int secondlargest(int[] arr) {
        if (arr == null || arr.length < 2) return -1;

        //if int[] arr = { Integer.MIN_VALUE, 5 }; the the second largest is Integer.MIN_VALUE
        // so we use long to avoid confusion (Integer first = Integer.MIN_VALUE)-> to second largest in Integer.MIN_VALUE hi hoga and we intial assume it as -1
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;

        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }

        return second == Long.MIN_VALUE ? -1 : (int) second;
    }
}
