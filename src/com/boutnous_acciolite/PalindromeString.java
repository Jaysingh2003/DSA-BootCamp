package com.boutnous_acciolite;

public class PalindromeString {

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("madam"));  // true
        System.out.println(isPalindrome("hello"));  // false
    }

//Palindrome ignoring spaces & special characters
    public static boolean isPalindromee(String str) {
        str = str.toLowerCase();
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }

            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}