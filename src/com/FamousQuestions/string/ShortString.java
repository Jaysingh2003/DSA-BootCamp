package com.FamousQuestions.string;

import java.util.Arrays;

public class ShortString {
    public static String sortString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(sortString("dcba")); // abcd
    }

}
