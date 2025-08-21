package com.operators;

//find the sum of nth row in pascal trangle
public class pascalTriangle {
    public static void main(String[] args) {
        int n = 4; // Example: 5th row
        System.out.println("Sum of " + n + "th row in Pascal's Triangle: " + pascalTriangle(n));

    }
    static int pascalTriangle(int n){
        // The sum of the nth row in Pascal's triangle is 2^n
       // return (int) Math.pow(2, n-1);

        int num= 1 << (n - 1); // Using bitwise left shift for efficiency and it is equivalent of the (int) Math.pow(2, n-1);
        return num;


    }
}
