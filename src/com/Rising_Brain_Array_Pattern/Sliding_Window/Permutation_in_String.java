package com.Rising_Brain_Array_Pattern.Sliding_Window;
import java.util.HashMap;
import java.util.Map;

public class Permutation_in_String {
    public boolean checkInclusion(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();
        if (n > m) {
            return false;
        }
        // Frequency map of s1
        Map<Character, Integer> mapS1 = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            mapS1.put(ch, mapS1.getOrDefault(ch, 0) + 1);
        }
        // Check every substring of length n
        for (int i = 0; i <= m - n; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = i; j < i + n; j++) {
                char ch = s2.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            if (isMatch(mapS1, map)) {
                return true;
            }
        }
        return false;
    }

    // Compare two frequency maps
    public boolean isMatch(Map<Character, Integer> map1,
                           Map<Character, Integer> map2) {
        return map1.equals(map2);
    }

    /// Ooptimized approach using sliding window
    public boolean checkPermutation(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();
        if (n > m) {
            return false;
        }
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        // Frequency of s1
        for (char ch : s1.toCharArray()) {
            freq1[ch - 'a']++;
        }
        int left = 0;
        for (int right = 0; right < m; right++) {
            // Expand the window
            freq2[s2.charAt(right) - 'a']++;
            // Shrink if window size exceeds n
            if (right - left + 1 > n) {
                freq2[s2.charAt(left) - 'a']--;
                left++;
            }
            // Check when window size becomes n
            if (right - left + 1 == n) {
                boolean isMatch = true;
                for (int i = 0; i < 26; i++) {
                    if (freq1[i] != freq2[i]) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    return true;
                }
            }
        }
        return false;
    }



    public static void main(String[] args) {
        Permutation_in_String obj = new Permutation_in_String();
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(obj.checkInclusion(s1, s2));
    }
}