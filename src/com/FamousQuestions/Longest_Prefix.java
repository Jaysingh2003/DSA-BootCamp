package com.FamousQuestions;

/// https://leetcode.com/problems/longest-common-prefix/description/
public class Longest_Prefix {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;

        if (n == 0) {
            return "";
        }

        String ref = strs[0];

        for (int i = 0; i < ref.length(); i++) {
            for (int j = 1; j < n; j++) {
                // if index out of range or characters don't match
                if (i >= strs[j].length() || strs[j].charAt(i) != ref.charAt(i)) {
                    return ref.substring(0, i);
                }
            }
        }

        return ref;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(new Longest_Prefix().longestCommonPrefix(strs));
    }
}
