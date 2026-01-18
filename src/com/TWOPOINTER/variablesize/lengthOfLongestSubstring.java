package com.TWOPOINTER.variablesize;

import java.util.HashMap;
/// https://leetcode.com/problems/longest-substring-without-repeating-characters/
///wiuthout repeating characters]
public class lengthOfLongestSubstring {
    public int lengthflongestsubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }

            map.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);//we comapere with th window size nopt the k like in previous problems
        }
        return maxLen;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring solution = new lengthOfLongestSubstring();
        String testString = "abcabcbb";
        int result = solution.lengthflongestsubstring(testString);
        System.out.println("Length of longest substring without repeating characters: " + result);
    }
}
