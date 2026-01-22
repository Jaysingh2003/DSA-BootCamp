package com.FamousQuestions.string;

public class Reverse_String {
    //first way using char array used when no library is used
    public static String reverseString(String str) {
        if (str == null) return null;
        char[] arr = str.toCharArray();   // convert to mutable array
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
        return new String(arr);
    }

    //second way using StringBuilder
    public class ReverseString {
        public static void main(String[] args) {
            String s = "hello";
            String reversed = new StringBuilder(s).reverse().toString();
            System.out.println(reversed);
        }
    }
}
