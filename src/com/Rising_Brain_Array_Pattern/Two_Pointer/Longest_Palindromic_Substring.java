package com.Rising_Brain_Array_Pattern.Two_Pointer;


//
public class Longest_Palindromic_Substring {
    /// Broute Force Solution
    public String longestSubstring(String s) {
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {

                if (isPalindrome(s, i, j)) {
                    if ((j - i + 1) > ans.length()) {
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }
        return ans;
    }

    boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /// Optimized apparich
    public String logestPalindromicSubstring(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            int l1 = expandFromCenter(s, i, i);///asume when there is the odd lenth string
            int l2 = expandFromCenter(s, i, i + 1);///asume ehrn there os the even length string.

            int len = Math.max(l1, l2);

            if (len > end - start) {
                start = i - (len - 1) / 2;///withb then lelp of this we can find the start index
                end = i + len / 2;/// with thje help of thos we can find the end index of the plaindrome
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


    public static void main(String[] args) {
        Longest_Palindromic_Substring obj = new Longest_Palindromic_Substring();
        System.out.println(obj.longestSubstring("babad")); // bab or aba

    }
}
