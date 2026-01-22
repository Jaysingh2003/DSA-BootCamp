package com.FamousQuestions.string;

// Java program to count special characters in a string
public class Count_Special_char {
    public static int countSpecialCharacters(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!Character.isLetterOrDigit(ch) && !Character.isWhitespace(ch)){//Character.isLetterOrDigit(ch) it is wrok on any hindi,english,digit  etc
                count++;
            }
        }
        return count;
    }

    // Alternative method without using built-in functions
    public static int countSpecialCharacters1(String str) {
        int count = 0;

        for (char ch : str.toCharArray()) {
            if (!(ch >= 'a' && ch <= 'z') &&
                    !(ch >= 'A' && ch <= 'Z') &&
                    !(ch >= '0' && ch <= '9') &&
                    ch != ' ') {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String str = "Hello@World! Welcome#to$Java%Programming^";
        int specialCharCount = countSpecialCharacters(str);
        System.out.println("Number of special characters: " + specialCharCount);
    }
}
