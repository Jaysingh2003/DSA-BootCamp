package com.TWOPOINTER.variablesize;

import java.util.HashMap;
import java.util.Map;

public class Longest_substring_k_unique_character {

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {

        int i = 0, j = 0;
        int maxLength = 0;

        Map<Integer, Integer> map = new HashMap<>();

        while (j < s.length()) {

            char ch = s.charAt(j);
            map.put((int) ch, map.getOrDefault((int) ch, 0) + 1);// Add character to the map

            // Shrink window if distinct characters exceed k
            while (map.size() > k) {
                char leftChar = s.charAt(i);
                map.put((int) leftChar, map.get((int) leftChar) - 1);

                if (map.get((int) leftChar) == 0) {
                    map.remove((int) leftChar);
                }
                i++;
            }

            // Update answer
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "eceeeba";
        int k = 2;
        int result = lengthOfLongestSubstringKDistinct(s, k);
        System.out.println("Length of longest substring with at most " + k + " distinct characters: " + result);
    }
}