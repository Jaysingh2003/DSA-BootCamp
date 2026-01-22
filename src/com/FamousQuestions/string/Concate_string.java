package com.FamousQuestions.string;

public class Concate_string {
    public static void main(String[] args) {
        String str1 = "Hello, ";//space is decide by here
        String str2 = "World!";

        // Using + operator
        String result1 = str1 + str2;
        System.out.println("Using + operator: " + result1);

        // Using concat() method
        String result2 = str1.concat(str2);
        System.out.println("Using concat() method: " + result2);
    }
    /// string seprated ny sp[ace
    /// //split() is used to divide a string into multiple parts based on a delimiter (regex) and return them as a String array.
    public static String splitBySpace(String str) {
        String[] parts = str.split("\\s+"); // one or more spaces it efficently handle
        StringBuilder result = new StringBuilder();
        for (String part : parts) {
            result.append(part);
        }
        return result.toString();
    }
}
