package com.Rising_Brain_Array_Pattern.Two_Pointer;


///https://leetcode.com/problems/reverse-string/description/
public class Reverse_String {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        Reverse_String rs = new Reverse_String();

        char[] arr1 = {'h','e','l','l','o'};
        rs.reverseString(arr1);
        System.out.println(arr1);

        char[] arr2 = {'H','a','n','n','a','h'};
        rs.reverseString(arr2);
        System.out.println(arr2);
    }
}
