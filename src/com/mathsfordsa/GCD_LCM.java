package com.mathsfordsa;

public class GCD_LCM {
    public static void main(String[] args) {
        int num= gcd(4,16);
        System.out.println(num);
        int num2=lcm(2,7);
        System.out.println(num2);

    }
    static  int gcd(int a,int b){
        if(a==0){
            return b;
        }
        return gcd(b%a,a);//recursive call
    }
    static int lcm(int a,int b){
        return (a*b)/gcd(a,b);
    }
}
