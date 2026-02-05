package com.String;

import java.util.HashMap;

/// https://leetcode.com/problems/word-pattern/description/
public class WordPattern {

    public boolean wordpattern(String patter, String s){
        String[] words = s.split(" ");
        if(patter.length() != words.length){
            return false;
        }

        HashMap<Character, String> hm = new HashMap<>();
        for(int i = 0; i < patter.length(); i++){
            char ch = patter.charAt(i);
            String word = words[i];

            if(hm.containsKey(ch)){
                if(!hm.get(ch).equals(word)){// Check if the mapped word is the same as the current word
                    return false;// If not, return false
                }
            } else {
                if(hm.containsValue(word)){// Check if the word is already mapped to another character
                    return false;
                }
                hm.put(ch, word);
            }
        }
        return true;
    }
}
