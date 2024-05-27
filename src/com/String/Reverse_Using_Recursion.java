package com.String;

public class Reverse_Using_Recursion {
    static String reverseRecursive(String str) {
        if (str == null || str.length() <= 1)
            return str;

        return reverseRecursive(str.substring(1)) + str.charAt(0);
    }
}
