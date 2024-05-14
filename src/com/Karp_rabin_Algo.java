package com;

/// Karp-Rabin String Matching Algorithm
/// 🧠 Core Concept
/// 	1.	Convert pattern into a number (hash)
/// 	2.	Convert first window of text into hash
/// 	3.	Slide window one by one
/// 	4.	Use rolling hash to update hash in O(1)
/// 	5.	If hash matches → compare characters
/// 🧠 Time Complexity
/// 	1.	Best/Average: O(n + m) → O(n)
/// 	2.	Worst: O(n * m) → O(n^2)
public class Karp_rabin_Algo {
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

        for (int i = 0; i <= textLength - patternLength; i++) {
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

    public static void main(String[] args) {
        Karp_rabin_Algo karpRabin = new Karp_rabin_Algo();
        String text = "ababcababcabc";
        String pattern = "abc";
        karpRabin.search(pattern, text);
    }

}
