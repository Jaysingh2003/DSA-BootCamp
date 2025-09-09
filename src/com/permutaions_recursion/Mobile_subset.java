package com.permutaions_recursion;

import java.util.ArrayList;

public class Mobile_subset {
    public static void main(String[] args) {
        String str = "12";
        pad("", str);
        System.out.println(pad_List("", str));
        System.out.println(count_pad("", str));


    }
    static void pad(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
       int digit = up.charAt(0) - '0';// converting char to int '2' into 2

        for (int i = (digit-1)*3; i < (digit*3); i++) { // for 2 it will start from 3 to 6
            char ch = (char)('a' + i);// converting int to char 0 into 'a' any charcter can be found by adding int to 'a'
            pad(p+ch, up.substring(1));
        }
    }

    static ArrayList<String> pad_List(String p, String up){
        if(up.isEmpty()){
                    ArrayList<String> list = new ArrayList<>();
                    list.add(p);
                    return list;
                }
                int digit = up.charAt(0) - '0';
                ArrayList<String> ans = new ArrayList<>();
                for (int i = (digit-1)*3; i < (digit*3); i++) {
                    char ch = (char)('a' + i);
                    ans.addAll(pad_List(p+ch, up.substring(1)));
                }
                return ans;
            }




    static int count_pad(String p, String up){
        if(up.isEmpty()){
            return 1;
        }
         int count = 0;
        int digit = up.charAt(0) - '0';// converting char to int '2' into 2
        for (int i = (digit-1)*3; i < (digit*3); i++) { // for 2 it will start from 3 to 6
            char ch = (char)('a' + i);// converting int to char 0 into 'a' any charcter can be found by adding int to 'a'
            count = count + count_pad(p+ch, up.substring(1));
        }
        return count;
    }

}
