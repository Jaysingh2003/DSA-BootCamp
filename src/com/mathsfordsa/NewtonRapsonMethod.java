package com.mathsfordsa;

public class NewtonRapsonMethod {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(sqrt(n));
    }

    static double sqrt(double n) {
        double x = n;
        double root = 0; // Declare root before the loop

        while (true) {
            root = 0.5 * (x + (n / x));
            if (Math.abs(root - x) < 0.5) {
                break;
            }
            x = root;
        }
        return root;
    }
}

//steps
//1. Start with an initial guess x (we can take x = n).
//2. Calculate a new guess using the formula: root = 0.5 * (x + n / x).
//3. Check if the absolute difference between the new guess and the and the old guess is less than a small threshold (0.5 in this case).