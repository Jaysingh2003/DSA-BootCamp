package com.FamousQuestions.string;

public class find_largest_word {
    public static String largestWord(String[] str) {
        String largest = str[0];
        for (int i = 1; i < str.length; i++) {
            if (str[i].length() > largest.length()) {
                largest = str[i];
            }
        }
        return largest;
    }

    //if the string paragphraph is given
    public static String largestWordInParagraph(String paragraph) {
        if (paragraph == null || paragraph.trim().isEmpty()) {
            return "";
        }

        String[] arr = paragraph.split("\\W+"); // split on non-word chars
        String max = "";

        for (String word : arr) {
            if (word.length() > max.length()) {
                max = word;
            }
        }
        return max;
    }

}
