package com.Aditya_String_Matching_Algo;

public class KMP_Algorithems {

    public int[] Compute_lps_array(String Pattern) {
        int m = Pattern.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;

        while (i < m) {
            if (Pattern.charAt(i) == Pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {/// if the string  did not matched then we check len kya h agar 0 lenth ki h to i++ karnge nahi to computed lps array ke index pr back jayenge
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    public void kmp_search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        int i = 0, j = 0;

        int[] lps = Compute_lps_array(pattern);
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }   // Pattern found
            if (j == m) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1];
                /// Mismatch
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
    }
}

