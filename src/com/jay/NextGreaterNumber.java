package com.jay;

public class NextGreaterNumber {

    public static int nextGreater(int n) {
        char[] digits = String.valueOf(n).toCharArray();

      //the i value will be 3 and  the value of digits[i] will be 4
        int i = digits.length - 2;



        // Step 1: Find the first digit that is smaller than the digit to its right
        //aisi pahli  didgit chahiye jo apne se right wale didgit se chhoti ho
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        // If no such digit is found, that means the digits are in descending order
        if (i < 0) {
            return -1; // No greater number possible
        }

        // Step 2: Find the smallest digit on right side of i  -> that is greater than digits[i]
        int j = digits.length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        // Step 3: Swap digits[i] and digits[j]
        swap(digits, i, j);

        // Step 4: Reverse the sub-array after i
        reverse(digits, i + 1, digits.length - 1);

        // Convert back to integer
        try {
            return Integer.parseInt(new String(digits));
        } catch (NumberFormatException e) {
            return -1; // Handle overflow
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }

    public static void main(String[] args) {

        int num = 14325;
        System.out.println(String.valueOf(num).length());
        int result = nextGreater(num);
        if (result == -1) {
            System.out.println("No greater number can be formed.");
        } else {
            System.out.println("Next greater number: " + result);
        }
    }
}