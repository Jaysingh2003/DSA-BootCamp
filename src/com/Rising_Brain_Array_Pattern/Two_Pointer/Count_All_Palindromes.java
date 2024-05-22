package com.Rising_Brain_Array_Pattern.Two_Pointer;

/// https://leetcode.com/problems/palindromic-substrings/description/
public class Count_All_Palindromes {

    /// Broute force solution to count no of palindrome
    public static int countpalindrome(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            String sub = " ";
            for (int j = i; j < n; j++) {
                sub += s.charAt(j);

                if (isPalindrome(sub)) {
                    count++;
                }
            }
        }
        return count;
    }

    /// /fxn to xheck palindrome
    public static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /// /optimzed approch
    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expandFromCenter(s, i, i);/// means int i is the part of  odd length
            count += expandFromCenter(s, i, i + 1);///for even length
        }
        return count;
    }

    public static int expandFromCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }
}
