package com.boutnous_acciolite;

import java.util.HashMap;
import java.util.HashSet;


// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// wiuthout repeating characters]
//step1: create a hashset to store the characters
//step2: create two pointers left and right to represent the window
//step3: iterate through the string with the right pointer
//step4: if the character at the right pointer is already in the hashset, remove characters from the left pointer until the character at the right pointer is not in the hashset
//step5: add the character at the right pointer to the hashset
//step6: update the maximum length of the substring
//step7: return the maximum length of the substring


public class Logest_Substring {
    public static int substringh(String s){
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;//itmeans ki jab tak duplicate character milega tab tak left pointer ko aage badhate raho
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;

    }
}
