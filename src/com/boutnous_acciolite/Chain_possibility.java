package com.boutnous_acciolite;


/// https://www.geeksforgeeks.org/problems/circle-of-strings4530/1
public class Chain_possibility {
    public static boolean canFormCircle(String[] arr) {
        int[] in = new int[26];
        int[] out = new int[26];

        for (String s : arr) {
            int first = s.charAt(0) - 'a';
            int last = s.charAt(s.length() - 1) - 'a';
            out[first]++;
            in[last]++;
        }

        for (int i = 0; i < 26; i++) {
            if (in[i] != out[i]) {
                return false;
            }
        }

        return true;
    }

}
//Imagine walking in a circle 🚶‍♂️
//        •	Every time you enter a character, you must also leave it
//	•	Otherwise, the chain breaks
//So for each character:
//
//number of times it starts a string
//=
//number of times it ends a string
//in[i] == out[i]