package com.boutnous_acciolite;


/// https://leetcode.com/problems/implement-strstr/description/
/// it is a string matching problem
/// complexity of the naive approach is O(n*m) where n is the length of the text and m is the length of the pattern
public class String_matching {

    public boolean isMatching(String pattern, String text) {
        if (pattern.length() > text.length())
            return false;// if the pattern is longer than the text, it cannot be a substring

        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            int j;
            for ( j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == pattern.length()) {// it means that we have found a match
                return true;
            }
        }
        return false;
    }

    /// optimised approach is to use the KMP algorithm which has a time complexity of O(n + m)
    /// where n is the length of the text and m is the length of the pattern

    /// Karp-Rabin String Matching Algorithm

    public class Karrprabin {
        private static final int prime = 101; // number of characters in the input alphabet

        private long calculateHash(String str) {//for claculate the hash value of the string
            long hash = 0;
            for (int i = 0; i < str.length(); i++) {
                hash += str.charAt(i) * Math.pow(prime, i);//for every character of the string calculate the hash value//Math.pow(prime, i) is a simple mathmatical fxn
            }
            return hash;
        }

        private long updateHash(long oldHash, char oldChar, char newChar, int patternLength) {
            long newHash = (oldHash - oldChar) / prime; // remove the old character
            newHash = (long) (newHash + newChar * Math.pow(prime, patternLength - 1)); // add the new character
            return newHash;////patternLength - 1) It represents the power position of the NEW character added at the end of the sliding window.
        }

        public void search(String pattern, String text) {
            int patternLength = pattern.length();
            int textLength = text.length();
            long patternHash = calculateHash(pattern);
            long textHash = calculateHash(text.substring(0, patternLength));// calculate the hash value of the first window of the text

            for (int i = 0; i <= textLength - patternLength + 1; i++) {
                if (patternHash == textHash) {// if the hash values match, check for actual string match to avoid hash collision
                    if (text.substring(i, i + patternLength).equals(pattern)) {
                        System.out.println("Pattern found at index: " + i);
                    }
                }// update the hash value for the next window of the text means the currenbt window that we take does not match
                if (i < textLength - patternLength) {
                    textHash = updateHash(textHash, text.charAt(i), text.charAt(i + patternLength), patternLength);
                }
            }
        }
    }

    public static void main(String[] args) {
        String_matching sm = new String_matching();
        Karrprabin kp = sm.new Karrprabin();
        kp.search("abc", "abcabc");
    }
}


