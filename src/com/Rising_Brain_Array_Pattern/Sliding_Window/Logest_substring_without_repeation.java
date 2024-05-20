package com.Rising_Brain_Array_Pattern.Sliding_Window;

import java.util.HashMap;
import java.util.HashSet;

/// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class Logest_substring_without_repeation {

    /// complexity O(n) and space O(n)
    public int logestsub(String s) {
        int n = s.length();
        int i = 0, j = 0;
        int max = 0;

        HashSet<Character> set = new HashSet<>();

        while (j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, j - i);
            } else {///if alredy presen the incoming character
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }

    /// 2nd way  using the index of the character and move the pointer to the next of the index of the character
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();// character and its index
        int i = 0;//i will move to the index of of new chater and j will move to the next character
        int max = 0;

        for (int j = 0; j < s.length(); j++) {

            char ch = s.charAt(j);
            ///Note :-  we use the math.max beciuse we did not want to move backword..
            if (map.containsKey(ch)) {// if the character is already present in the map then move the i to the next of the index of the character
                i = Math.max(i, map.get(ch) + 1);//if the duplicate is found then we will move the i to the next of the old occurenec if the chaterer
                ///(simly means old i ke next elemnt par i ki rakhege) //with the help of this we did not move one by one we will directly move to the next of the old occurence of the character and we will not move back the i pointer if the duplicate is found again
            }
            map.put(ch, j);
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}
