package com.Aditya_String_Matching_Algo;

public class Test {
    public String leeftstring(String str, int n){
        String str1="";
        for(int i = 0; i<=n; i++){
            str1=str1+str;
        }

        return str1;
    }


    public static void main(String[] args) {
        Test t=new Test();
        System.out.println(t.leeftstring("aditya",3));
    }
}
