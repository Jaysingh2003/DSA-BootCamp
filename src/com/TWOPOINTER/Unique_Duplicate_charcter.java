package com.TWOPOINTER;

import java.util.HashMap;
import java.util.Map;

public class Unique_Duplicate_charcter {
    public static void uniqueChars(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add right character to window
            char rChar = s.charAt(right);
            map.put(rChar, map.getOrDefault(rChar, 0) + 1);

            // When window size becomes k
            if (right - left + 1 == k) {

                // Print unique characters in current window
                System.out.println(map.keySet());

                // Remove left character (slide window)
                char lChar = s.charAt(left);
                map.put(lChar, map.get(lChar) - 1);

                if (map.get(lChar) == 0) {
                    map.remove(lChar);
                }

                left++;
            }
        }
    }

    //find duplicate characters in a string of size k
    public static void duplicateChars(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {

            // Add right character to window
            char rChar = s.charAt(right);
            map.put(rChar, map.getOrDefault(rChar, 0) + 1);

            // When window size becomes k
            if (right - left + 1 == k) {

                // Print duplicate characters in current window
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (entry.getValue() > 1) {
                        System.out.print(entry.getKey() + " ");
                    }
                }
                System.out.println();

                // Remove left character (slide window)
                char lChar = s.charAt(left);
                map.put(lChar, map.get(lChar) - 1);

                if (map.get(lChar) == 0) {
                    map.remove(lChar);
                }

                left++;
            }
        }
    }
}