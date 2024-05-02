package com.Aditya_Stack_Questions;


///
public class Rain_Water_Trapping {


    public static int trap(int[] arr) {
        int n = arr.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        // Fill maxLeft
        maxLeft[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], arr[i]);
        }
        // Fill maxRight
        maxRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], arr[i]);
        }
        // Calculate trapped wate
        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(maxLeft[i], maxRight[i]) - arr[i];
        }
        return water;

    }

    public static void main(String[] args) {

        int[] arr = {3, 0, 0, 2, 0, 4};

        System.out.println(trap(arr));

    }
}
