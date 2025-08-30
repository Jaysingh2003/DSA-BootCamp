package com.recursion_1;

public class palindrome {
    public static void main(String[] args) {
        int n = 12321;
        System.out.println(isPalindrome(n));

        String str = "1231";
        System.out.println(isPalindrome2(str));

    }
    static boolean isPalindrome(int n){
      if(n == helper(n, (int)Math.log10(n)+1)){
          return true;
      }
      return false;
    }
    static int helper(int n, int digits){
        if(n%10==n){
            return n;
        }
        return (n%10)* (int)Math.pow(10, digits-1) + helper(n/10, digits-1);

    }


    //another approach strings--
    static boolean isPalindrome2(String str){
        return helper2(str, 0, str.length()-1);
    }
    static boolean helper2(String str, int start, int end){
        while(start>=end) {
            return true;
        };
            if(str.charAt(start)!=str.charAt(end)){
            return false;
        }
        return helper2(str, start+1, end-1);
}
    }