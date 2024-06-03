package com.boutnous_acciolite;

import java.util.*;

/// anagram means that two strings are made of the same characters in the same frequency but can be in different order
/// tame and space complexity of the optimal approach is O(n) where n is the length of the strings
/// (since we are traversing both strings once and using a hash map to store character counts)
public class AnagramCheck {

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray()) {
            if (!map.containsKey(c)) return false;// if the character from s2 is not present in the map, it means s1 and s2 cannot be anagrams
            map.put(c, map.get(c) - 1);//if present then descrement the count of that character in the map
            if (map.get(c) < 0) return false;// if the count of any character becomes negative, it means s2 has more occurrences of that character than s1, so they cannot be anagrams
        }

        return true;
    }

    /// alternate if you want to use the counting array approach (only for lowercase letters)
    /// Time: O(n) and Space: O(1) since we are using a fixed size array of 26 characters
    public static boolean isAnagram1(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] count = new int[26];//by defalt all values in the count array will be initialized to 0
/// count['a' - 'a']++ → count[0]++ // Increment the count for 'a' (index 0)
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : s2.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) return false;
        }

        return true;
    }

    /// brute force approach (Sort both strings and compare) Time: O(n log n) and Space: O(n) due to sorting
    public class AnagramBruteForce {

        public static boolean isAnagram(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }

            char[] a = s1.toCharArray();
            char[] b = s2.toCharArray();

            Arrays.sort(a);
            Arrays.sort(b);

            return Arrays.equals(a, b);
        }

        public static void main(String[] args) {
            System.out.println(isAnagram("listen", "silent")); // true
            System.out.println(isAnagram("rat", "car"));       // false
        }
    }
}