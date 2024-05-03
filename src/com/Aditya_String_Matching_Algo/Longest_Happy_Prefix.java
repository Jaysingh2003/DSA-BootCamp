package com.Aditya_String_Matching_Algo;


/// https://leetcode.com/problems/longest-happy-prefix/description/

public class Longest_Happy_Prefix {
    public String longestPrefix(String s) {

        int n = s.length();
        int i = 1;
        int len = 0;
        int[] lps = new int[n];

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {//if it is not on the first position
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return s.substring(0, lps[n - 1]);


    }
    public static void main(String[] args) {
        Longest_Happy_Prefix l = new Longest_Happy_Prefix();
        System.out.println(l.longestPrefix("level"));
    }

}
