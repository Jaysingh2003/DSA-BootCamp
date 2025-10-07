package com.StringBuffer;

import java.util.Random;

public class RandomCharecter {
    public static String genrateRandomCharecter( int size){
        StringBuilder sb = new StringBuilder();

        Random random = new Random();
        for(int i=0; i<size; i++){
            int ransichar = (int)(97 + random.nextFloat() * 26);
            sb.append((char)ransichar);
        }
        return sb.toString();
    }


}
