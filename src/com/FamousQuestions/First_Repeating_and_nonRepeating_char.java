package com.FamousQuestions;

import java.util.HashMap;
import java.util.Map;

public class First_Repeating_and_nonRepeating_char {

    // Function to find the first repeating character in a string
    public static char firstNonreopatingcharacter(String str) {

        if (str == null || str.isEmpty()) return '\0';
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : str.toCharArray()){
            if (map.get(ch) == 1){
                return ch;
            }
        }
        return '\0'; // Return null character if no non-repeating character is found

    }

    // Function to find the first non-repeating character in a string
    public static char firstRepeatingcharacter(String str) {
        if (str == null || str.isEmpty()) return '\0';
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : str.toCharArray()){
            if (map.get(ch) > 1){
                return ch;
            }
        }
        return '\0'; // Return null character if no repeating character is found
    }
}