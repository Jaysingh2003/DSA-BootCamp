package com.recursion_InString;

public class Stream_remove_the_character {
    public static void main(String[] args) {
        skip("", "baccad");
        System.out.println();

        System.out.println(skip2("baccahjyd"));
    }

    static void skip(String p, String up) {//proccssed and unprocessed string
        if (up.isEmpty()) {
            System.out.print(p);
            return;
        }
        char currChar = up.charAt(0);
        if (currChar == 'a') {
            skip(p, up.substring(1));//sunstring(1) removes the first character of the string
        } else {
            skip(p + currChar, up.substring(1));//up.substring(1) removes the first character of the string
            //everytime we remove the first character of the string
        }
    }

    //another way in which we returning
    static String skip2(String s) {
        if (s.isEmpty()) {
            return "";
        }
        char currChar = s.charAt(0);
        if (currChar == 'a') {
            return skip2(s.substring(1));
        } else {
            return currChar + skip2(s.substring(1));
        }
    }
}