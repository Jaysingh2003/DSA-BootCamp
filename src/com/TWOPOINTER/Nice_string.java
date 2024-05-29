package com.TWOPOINTER;

import java.util.HashSet;
import java.util.Set;

public class Nice_string {

    public static String findnicestring(String s) {
        if (s.length() < 2) return "";
// Step1- find the unique characters in the string
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            set.add(c);
        }
        /// Step2- itrate throgh the loop and find the logest substring
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (set.contains(Character.toLowerCase(c)) && set.contains(Character.toUpperCase(c))) {
                continue;
            } else {/// if the character is not present in both cases then we will split the string into two parts and find the longest substring
            /// using the recursion.
                String left = findnicestring(s.substring(0, i));// find the longest substring in the left part
                String right = findnicestring(s.substring(i + 1));// find the longest substring in the right part
                return left.length() >= right.length() ? left : right;
            }
        }

        return s;
    }
}