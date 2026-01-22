package com.FamousQuestions.string;

public class Remove_vowel {
    public static String removeVowels(String str) {
        String vowels = "aeiouAEIOU";
        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (vowels.indexOf(c) == -1) {//indexOf Returns index if found oitys and -1 if not found its an string method
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "Hello World!";
        String output = removeVowels(input);
        System.out.println("Original String: " + input);
        System.out.println("String after removing vowels: " + output);
    }
}
