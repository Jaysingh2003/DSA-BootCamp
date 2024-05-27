package com.String;
// https://leetcode.com/problems/reverse-words-in-a-string/description/

///Split the string, iterate from end, append using StringBuilder.
/// Time: O(n)
/// 📦 Space: O(n)
public class Reverse_Words_in_a_Sentence {
    static String reverseWords(String str) {
        if (str == null || str.length() == 0) return str;

        String[] words = str.trim().split("\\s+");//
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }

        return sb.toString().trim();
    }
}
