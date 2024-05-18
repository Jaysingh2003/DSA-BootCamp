package com.Reverse_All_type_problem;

/// https://leetcode.com/problems/reverse-string/
public class Reverse_a_String {

    // type-1:- Two pointer approach using char array, complexity O(n) and space O(n)
    public static String reverseString(String str) {
        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }
    // type-2:- Using StringBuilder compxity O(n) and space O(n)
    public static String reverseStringUsingStringBuilder(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    // type-3:- Using recursion complexity O(n) and space O(n) because of the recursive call stack
    public static String reverseStringUsingRecursion(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        //str.substring(1,4) means it will return the substring starting from index 1 to index 3 (4-1)
        return reverseStringUsingRecursion(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String str = "hello world";
        String result = reverseString(str);
        String result2 = reverseStringUsingStringBuilder(str);
        System.out.println(result);
        System.out.println(result2);
    }



}
