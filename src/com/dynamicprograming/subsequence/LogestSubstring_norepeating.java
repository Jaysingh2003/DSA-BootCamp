package com.dynamicprograming.subsequence;
import java.util.HashSet;

///  length of the longest substring without repeating characters.
public class LogestSubstring_norepeating {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashSet<Character> set = new HashSet<>();
            int left = 0, maxLen = 0;

            for (int right = 0; right < s.length(); right++) {
                while (set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(s.charAt(right));
                maxLen = Math.max(maxLen, right - left + 1);
            }
            return maxLen;
        }
    }

    public static void main(String[] args) {
        LogestSubstring_norepeating outer = new LogestSubstring_norepeating();
        Solution solution = outer.new Solution();
        String s = "abcabcbb";
        int result = solution.lengthOfLongestSubstring(s);
        System.out.println("Length of longest substring without repeating characters: " + result);
    }

}
