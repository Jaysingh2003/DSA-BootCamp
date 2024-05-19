package com.Reverse_All_type_problem;

/// Reverse the order of words in a sentence
/// Input: "i love java"
/// Output: "java love i"
/// complexity: O(n)
public class reverse_order_of_sentence {

    /// https://leetcode.com/problems/reverse-words-in-a-string/
    public static String reverseWordOrder(String str) {

        String[] words = str.split("\\s+");// split the string into words using whitespace as a delimiter
        StringBuilder result = new StringBuilder();// use StringBuilder for efficient string concatenation

        for (int i = words.length - 1; i >= 0; i--) {// iterate through the words array in reverse order
            result.append(words[i]).append(" ");// append each word followed by a space to the result
        }

        return result.toString().trim();// convert the StringBuilder to a String and trim any leading or trailing whitespace
    }
}
