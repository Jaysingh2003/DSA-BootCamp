package com.boutnous_acciolite;

public class Reverse_vowel {


    /// Function to reverse vowels in a string
    /// using two-pointer technique
    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (!isVowel(chars[start])) {
                start++;
            } else if (!isVowel(chars[end])) {
                end--;
            } else {
                // Swap vowels
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }

        return new String(chars);
    }

    private static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String input = "hello";
        String result = reverseVowels(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + result);

    }
}