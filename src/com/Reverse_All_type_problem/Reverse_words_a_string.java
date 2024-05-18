package com.Reverse_All_type_problem;

/// Reverse words in a string
/// Input: "Hello World"
/// Output: "olleH dlroW"
/// complexity: O(n)
/// space complexity: O(n)
public class Reverse_words_a_string {

    public static String reverseWords(String str) {

        String[] words = str.split("\\s+");// split the string into words using whitespace as a delimiter
        StringBuilder result = new StringBuilder();// use StringBuilder for efficient string concatenation

        for (String word : words) {// iterate through each word in the words array

            for (int i = word.length() - 1; i >= 0; i--) {// iterate through each character of the word in reverse order
                result.append(word.charAt(i));// append each character to the result
            }

            result.append(" ");// append a space after each reversed word
        }

        return result.toString().trim();// convert the StringBuilder to a String and trim any leading or trailing whitespace
    }

    public static void main(String[] args) {
        String input = "Hello World";
        String output = reverseWords(input);
        System.out.println(output); // Output: "olleH dlroW"
    }
}