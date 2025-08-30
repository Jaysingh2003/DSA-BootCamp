package com.recursion_1;

public class CountZeroes {
    public static void main(String[] args) {
        int n = 1020304050;
        //System.out.println(countZeroes(n));
        System.out.println(countZeroes2(n));
    }

    static int countZeroes(int n) {
        if (n == 0) {
            return 0;
        }
        int lastaDigit = n % 10;
        int smallAns = countZeroes(n / 10);
        if (lastaDigit == 0) {
            return smallAns + 1;
        }
        return smallAns;
    }


    //another approach
    static int countZeroes2(int n) {
        return helper(n, 0);
    }
    static int helper(int n, int count){
       if(n == 0){
           return count;
       }
       int lastDigit = n % 10;
       if(lastDigit== 0){
           return helper(n/10, count+1);
       }
       return helper(n/10, count);

    }
}
