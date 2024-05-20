package com.Rising_Brain_Array_Pattern.Sliding_Window;

import java.util.Arrays;

///* Time: O(n)
///* Space: O(26 + 26) = O(1) (constant extra space).
//anagram count in a string means ki hume ye count krna hai ki given pattern ke kitne anagram text me present hai
public class AnaGram_count {

    public static int countAnagrams(String text, String pattern) {

        int[] patternFreq = new int[26];
        int[] windowFreq = new int[26];
        int k = pattern.length();
        int n = text.length();

        if (k > n) return 0;

        // 1️⃣ pattern frequency-> it will be only one time hona chahiye
        for (char ch : pattern.toCharArray()) {//for each character in pattern we are calculating the frequency and storing in patternFreq array
            patternFreq[ch - 'a']++;///ch - 'a' is used to convert the character to an index in the frequency array. For example, if ch is 'a', then 'a' - 'a' = 0, so it will increment patternFreq[0]. If ch is 'b', then 'b' - 'a' = 1, so it will increment patternFreq[1], and so on.
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
        for (int i = 0; i < n - k; i++) {/// we are sliding the window from index 0 to n-k because we need to check the last window which starts at n-k and ends at n-1

            int removeIndex = text.charAt(i) - 'a';// we are removing the character at index i because we are sliding the window to the right
            int addIndex = text.charAt(i + k) - 'a';// we are adding the charter at index k+i;

            windowFreq[removeIndex]--;// we are decrementing the frequency of the character that is removed from the window
            windowFreq[addIndex]++;// we are incrementing the frequency of the character that is added to the window

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