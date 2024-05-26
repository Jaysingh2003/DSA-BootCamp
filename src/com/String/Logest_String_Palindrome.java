package com.String;

/// https://leetcode.com/problems/longest-palindromic-substring/description/
public class Logest_String_Palindrome {

    public static String LogestPalindrome(String s){

        if(s == null || s.length()<1){
            return "";
        }
        int start = 0;
        int end = 0;
        for(int i=0; i<s.length(); i++){
            int len1 = expandAroundCenter(s, i, i);//for odd length palindrome
            int len2 = expandAroundCenter(s, i, i+1);//for even length palindrome
            int len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len-1)/2;//becaouse 0 index so len-1 and diveided by 2  that is the left side
                end = i + len/2;//start from i and add len/2 that is the right side
            }
        }
        return s.substring(start, end+1);
    }

    private static int expandAroundCenter(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }

}
