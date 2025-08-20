package com.operators;


// Time Complexity: log(n)
public class NoOfDigitofBaseN {
    public static void main(String[] args) {
        int n = 10; // Number to find the number of digits [10 in binary should give me 1010]
        int base = 2; // Base in which to find the number of digits

        // Calculate the number of digits in base 'base' its like lo
        int noOfDigits = (int) (Math.log(n) / Math.log(base)) + 1;//

        // Print the result
        System.out.println("Number of digits in base " + base + " for number " + n + " is: " + noOfDigits);
    }

}
/*

log n to the base b is equal to log n / log b
 */