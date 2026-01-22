package com.FamousQuestions.string;

public class Spilit_by_space {

    public static String[] splitString(String str) {
        String[] arr = str.split("\\s+");

        for (String s : arr) {
            System.out.println(s);
        }

        return arr;   // ✅ required
    }

    public static void main(String[] args) {
        splitString("Hello World Java Programming");
    }
}