package com.String;

public class Palindrom_sentance {


//    s.replaceAll("[^a-zA-Z0-9]", "")  ( ^ inside []  NOT)
//
//    Remove everything except letters and numbers.
//    Output:
//    amanaplanacanalpanama
        public boolean isPalindrome(String s) {
            s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();


            int left = 0;
            int right = s.length() - 1;

            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }

            return true;
        }

    }

