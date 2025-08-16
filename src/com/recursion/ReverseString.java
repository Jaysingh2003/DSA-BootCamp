package com.recursion;

import java.lang.reflect.Array;
import java.util.Arrays;

// Reverse a string using recursion
public class ReverseString {
    public static void main(String[] args) {
      char[] arr = {'h','e','l','l','o'};
        char[] arr1 = {'h','e','l','l','o'};
        reverse(arr);
        System.out.println(Arrays.toString(arr));

        Solution s= new Solution();
        s.reverseString(arr1);
        System.out.println(Arrays.toString(arr1));




    }
    static void reverse(char[] s){
        reversehelper(s, 0, s.length - 1);
    }
    static void reversehelper(char[] s, int left, int right) {
        if (left >= right) {
            return;
        }
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        reversehelper(s, left + 1, right - 1);
    }
}
//(In-place Reverse)
class Solution {
   static public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
/*
temporary array:
class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        char[] temp = new char[n];

        for (int i = 0; i < n; i++) {
            temp[i] = s[n - 1 - i];
        }

        // Copy back into original array
        for (int i = 0; i < n; i++) {
            s[i] = temp[i];
        }
    }
}
 */