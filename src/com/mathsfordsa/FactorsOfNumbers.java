package com.mathsfordsa;

import java.util.ArrayList;

public class FactorsOfNumbers {
    public static void main(String[] args) {
        int number = 20; // Example number
        printFactors(number);
        System.out.println();
        printFactors2(number);

    }

    //o(n) complxity solution
    static void printFactors(int number) {
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    //o(sqrt(n)) complexity solution
    static void printFactors2(int number) {
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                if (number / i == i) { // To avoid printing the square root twice in case 36 two time the 6 will come
                    System.out.print(i + " ");
                } else { // To avoid printing the square root twice in case 36 two time the 6 will come
                    System.out.print(i + " ");
                    factors.add(number / i);
                }
            }
        }
        for (int i = factors.size() - 1; i >= 0; i--) {//for printing in revese order of the no 20,10,5 ->5,10,20
            System.out.print(factors.get(i) + " ");
        }
    }
}

