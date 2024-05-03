package com.Aditya_String_Matching_Algo;

/// find  karna h ki string A ko kitne bari repeat kare ki String B ek substring ho jkaye of string A ka

public class Repeated_String_Match {

    // Repeated String Match
    public int repeatedStringMatch(String A, String B) {

        int m = A.length();
        int n = B.length();

        /// Build A + first (n-1) characters
        StringBuilder sb = new StringBuilder(A);

        for (int i = 0; i < n - 1; i++) {
            sb.append(A.charAt(i % m));
        }

        String text = sb.toString();

        // Find pattern using KMP
        int startIndex = kmp_search(text, B);

        if (startIndex == -1) {
            return -1;
        }

        // Calculate minimum repetitions
        int endIndex = startIndex + n;

        return (endIndex + m - 1) / m; // ceil(endIndex / m)
    }

    // Compute LPS Array
    public int[] Compute_lps_array(String pattern) {

        int m = pattern.length();
        int[] lps = new int[m];///int[] lps = new int[m]; // already filled with 0 if yopu want to you can also wriote lps[0] = 0.


        int len = 0;
        int i = 1;

        while (i < m) {

            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {

                if (len != 0) {
                    len = lps[len - 1];
                } else {///this will add the  first position 0
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    // KMP Search
    public int kmp_search(String text, String pattern) {

        int n = text.length();///actual string
        int m = pattern.length();

        int[] lps = Compute_lps_array(pattern);

        int i = 0;
        int j = 0;

        while (i < n) {

            // Match
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            // Pattern Found
            if (j == m) {
                return i - j; // starting index
            }
            // Mismatch
            else if (i < n && text.charAt(i) != pattern.charAt(j)) {

                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Repeated_String_Match obj = new Repeated_String_Match();
        System.out.println(obj.repeatedStringMatch("abcd", "cdabcdab")); // 3
        System.out.println(obj.repeatedStringMatch("a", "aa")); // 2
        System.out.println(obj.repeatedStringMatch("abc", "cabca")); // 3
    }
}
