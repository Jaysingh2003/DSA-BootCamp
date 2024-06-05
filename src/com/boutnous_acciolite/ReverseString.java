package com.boutnous_acciolite;

public class ReverseString {

    static String reverse(String str) {
        // base case
        if (str.length() == 0) {
            return str;
        }
        // recursive call
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(reverse("abcd"));
    }
}