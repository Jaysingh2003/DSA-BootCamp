package com.array;

import java.util.*;

class UserMainCode {
    public int asciiMod(String input1){
        int[] f = new int[26];
        for(char c : input1.toCharArray()) f[c - 'a']++;
        int s = 0;
        for(int i = 0; i < 26; i++){
            if(f[i] > 0){
                int total = (i + 97) * f[i];
                int m = total % 5;
                if(m != 0) s += m;
            }
        }
        return s;
    }
}