package com.Rising_Brain_Array_Pattern.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

/// https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
/// longest substring with at most k unique characters
///
/// we did not use the set although it contain the unique element  but during the shrinking phase when we remove the
/// left elemnt from the set  but we have no idea of how many repeation of that clemnt in the string.
public class Longest_substring_k_unique_character {

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {

        int i = 0, j = 0;
        int maxLength = -1;

        Map<Character, Integer> map = new HashMap<>();

        ///Expanding phase
        while (j < s.length()) {

            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() > k) {
                char leftChar = s.charAt(i);
                ///shrinking phase
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                i++;
            }
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