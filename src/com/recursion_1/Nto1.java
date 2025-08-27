package com.recursion_1;

public class Nto1 {
    public static void main(String[] args) {
        //nto1(5);
        onetoN(5);
    }

    static void nto1(int n) {// output 5,4,3,2,1
        if (n == 0) {
            return;
        }
        System.out.println(n);
        nto1(n - 1);
    }

    //if we want to print 1 to n[
    static void onetoN(int n) {// output 1,2,3,4,5
        if (n == 0) {
            return;
        }

        onetoN(n - 1);
        System.out.println(n);

    }

    static void nto1andthen1ton(int n) {// output 5,4,3,2,1,1,2,3,4,5
        if (n == 0) {
            return;
        }
        System.out.println(n);
        nto1andthen1ton(n - 1);
        System.out.println(n);
    }
}
//while it forming the recursion call it will print 5,4,3,2,1 and when the fxn will remove from the stack it will print 1,2,3,4,5