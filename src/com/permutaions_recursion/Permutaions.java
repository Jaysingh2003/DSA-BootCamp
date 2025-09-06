package com.permutaions_recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutaions {
    public static void main(String[] args) {
        String str = "abc";
        permutaion("", str);
        System.out.println(permutaion_List("", str));
        System.out.println(countPermutations("", str));
    }


    static void permutaion(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {// i<=p.length() because the the index of string is from 0 and
            //and the process string alson starts from 0 so we have to include the last index also
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permutaion(f + ch + s, up.substring(1));//
        }

    }

    //if we add to the list then we can return the list of permutaions
    static ArrayList<String> permutaion_List(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        //this list is local   store the permutaions of each function call
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            ans.addAll(permutaion_List(f + ch + s, up.substring(1)));//
            //up.substring(1)) remove the first char from the up string

        }
        return ans;

    }

    static int countPermutations(String p, String up){
        if(up.isEmpty()) {
            return 1;
        }
        char ch = up.charAt(0);
        int count = 0;
        for(int i=0;i<=p.length();i++){
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            count = count + countPermutations(f+ch+s,up.substring(1));
        }
        return count;
    }
}