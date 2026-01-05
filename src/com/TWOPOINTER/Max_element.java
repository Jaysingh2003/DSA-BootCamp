package com.TWOPOINTER;

public class Max_element {

    public static int[] findmaxelement(int[] arr, int k) {
        int n = arr.length;
        int i = 0, j = 0;
        int index = 0;

        int[] res = new int[n - k + 1];

        while (j < n) {

            if (j - i + 1 < k) {
                j++;
            }
            else if (j - i + 1 == k) {

                int max = Integer.MIN_VALUE;
                for (int m = i; m <= j; m++) {
                    max = Math.max(max, arr[m]);
                }

                res[index++] = max;

                // slide the window
                i++;
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = findmaxelement(arr, k);

        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}