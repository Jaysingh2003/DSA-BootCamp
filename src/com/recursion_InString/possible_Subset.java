package com.recursion_InString;

import java.util.ArrayList;

public class possible_Subset {
    public static void main(String[] args) {
        String str = "abc";
        subset("", str);
        System.out.println(subsetOfString("", str));
        System.out.println(subsetWithASCII("", str));

    }

    static void subset(String p, String up) {//p is the processed part and up is the unprocessed part
        if (up.isEmpty()) {
            System.out.println(p);//when the unprocessed part is empty, print the processed part
            return;
        }
        char ch = up.charAt(0);
        subset(p, up.substring(1));//exclude the character
        subset(p + ch, up.substring(1));//include the character


    }

    //if we have to return the subset in the form of an arraylist then we can do it like this
    static ArrayList<String> subsetOfString(String p, String up) {
        if (up.isEmpty()) {
            //after the up is empty all the element are in p so we have to return p in the form of an arraylist
            ArrayList<String> list = new ArrayList<>();
            list.add(p);//add p to the list
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subsetOfString(p, up.substring(1));//exclude the character
        ArrayList<String> right = subsetOfString(p + ch, up.substring(1));//include the character
        left.addAll(right);
        return left;//we can return any one of them because both contains all the subset
    }

    //fint the ascii value of the subset
    static ArrayList<String> subsetWithASCII(String p, String up) {
        if (up.isEmpty()) {
            //after the up is empty all the element are in p so we have to return p in the form of an arraylist
            ArrayList<String> list = new ArrayList<>();
            list.add(p);//add p to the list
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> first = subsetWithASCII(p, up.substring(1));//exclude the character
        ArrayList<String> second = subsetWithASCII(p + ch, up.substring(1));//include the character
        ArrayList<String> third = subsetWithASCII(p + (ch + 0), up.substring(1));//include the ascii value of the character
         first.addAll(second);
         first.addAll(third);
        return first ;//we can return any one of them because both contains all the subset
    }

}
