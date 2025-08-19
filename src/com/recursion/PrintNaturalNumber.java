package com.recursion;

public class PrintNaturalNumber {
    public static void main(String[] args) {
        print(1);
        printNos(50);
    }
    public static void print(int n) {
        if (n > 10) {
            return; // Base case: stop when n exceeds 10
        }
        System.out.println(n); // Print the current number in ascending oredre
        print(n + 1); // Recursive call with the next number
        //System.out.println(n); //Print the current numberin descendiong order
    }

//anotrnher way to print natural numbers using recursion
//https://www.geeksforgeeks.org/problems/print-1-to-n-without-using-loops-1587115620/1


    public static void printNos(int n) {
        // Code here
        if(n==0) return;

        printNos(n-1);
        System.out.print(n+" ");

    }
}
