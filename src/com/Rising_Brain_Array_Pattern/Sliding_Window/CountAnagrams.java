package com.Rising_Brain_Array_Pattern.Sliding_Window;

import java.util.HashMap;

public class CountAnagrams {

    ///this is similoar to that of AnaGramCount  question in this we use the map and frequency count insated
    /// Arrays.equals although both have the complxity is O(n) and space in o(1)
    public static int countAnagrams(String text, String pattern) {

        int n = text.length();
        int k = pattern.length();

        if (k > n) return 0;

        // Frequency map of pattern
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : pattern.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Number of unique characters to match
        int count = map.size();

        int i = 0;
        int j = 0;
        int ans = 0;

        while (j < n) {

            // Include current character into the window
            char right = text.charAt(j);

            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);

                if (map.get(right) == 0) {
                    count--;
                }
            }

            // Window size is smaller than k
            if (j - i + 1 < k) {
                j++;
            }

            // Window size becomes k
            else if (j - i + 1 == k) {

                // All characters matched
                if (count == 0) {
                    ans++;
                }

                // Remove left character before sliding
                char left = text.charAt(i);

                if (map.containsKey(left)) {

                    map.put(left, map.get(left) + 1);

                    if (map.get(left) == 1) {
                        count++;
                    }
                }

                i++;
                j++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        String text = "forxxorfxdofr";
        String pattern = "for";

        System.out.println(countAnagrams(text, pattern));
    }
}