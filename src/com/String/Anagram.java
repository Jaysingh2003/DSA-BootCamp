package com.String;

import com.oops.acces.A;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String s = "hello";
        String t = "olheh";
        boolean ans = anagram(s, t);
        System.out.println(ans);  // should print true


    }

    static boolean anagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }
}