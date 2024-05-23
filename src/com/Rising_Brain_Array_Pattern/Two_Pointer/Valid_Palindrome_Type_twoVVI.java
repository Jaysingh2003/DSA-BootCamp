package com.Rising_Brain_Array_Pattern.Two_Pointer;

///https://leetcode.com/problems/valid-palindrome-ii/description/
///
///Complexity we check in first loop O(n) and in first code we call the fxn  the below fxn two time  n/2+n/2 = n
/// And total n+n= 2n times the loop will run
public class Valid_Palindrome_Type_twoVVI {
    public Boolean validpalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return ispalindrome(s, left + 1, right) || ispalindrome(s, left, right - 1);///if any one fxn will retun true it means
                /// string is palindrome otherwise its not a palindrome
            }
            left++;
            right--;
        }
        return true;
    }
    private boolean ispalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
