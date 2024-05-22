package com.Rising_Brain_Array_Pattern.Two_Pointer;


///https://leetcode.com/problems/valid-palindrome/description/
///Reomve the special symbol and then chck the palindrome..
public class Check_Palindrome {
    public boolean checkPalindrome(String str) {
        String s = str.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String[] s1 = s.split(" ");
        str = String.join("", s1);
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Check_Palindrome cp = new Check_Palindrome();
        System.out.println(cp.checkPalindrome("A man, a plan, a canal: Panama"));
    }
}
