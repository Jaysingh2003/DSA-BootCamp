package com.TWOPOINTER;

import java.util.Arrays;

public class AnaGram_count {

    public static int countAnagrams(String text, String pattern) {

        int[] patternFreq = new int[26];
        int[] windowFreq = new int[26];

        int k = pattern.length();
        int n = text.length();

        if (k > n) return 0;

        // 1️⃣ pattern frequency
        for (char ch : pattern.toCharArray()) {
            patternFreq[ch - 'a']++;
        }

        // 2️⃣ initialize FIRST window of size k
        for (int i = 0; i < k; i++) {
            windowFreq[text.charAt(i) - 'a']++;
        }

        int count = 0;

        // 3️⃣ check first window
        if (Arrays.equals(patternFreq, windowFreq)) {
            count++;
        }

        // 4️⃣ slide the window
        for (int i = 0; i < n - k; i++) {

            int removeIndex = text.charAt(i) - 'a';
            int addIndex = text.charAt(i + k) - 'a';

            windowFreq[removeIndex]--;
            windowFreq[addIndex]++;

            if (Arrays.equals(patternFreq, windowFreq)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String text = "forxxorfxdofr";
        String pattern = "for";
        int result = countAnagrams(text, pattern);
        System.out.println("Number of anagrams: " + result);
    }
}