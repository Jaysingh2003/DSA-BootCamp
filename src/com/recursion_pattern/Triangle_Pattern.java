package com.recursion_pattern;

public class Triangle_Pattern {
    public static void main(String[] args) {
        traiangle(4, 0);
        triangle2(4, 0);

    }

    static void traiangle(int r, int c) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            System.out.print(" *");
            traiangle(r, c + 1);
        } else {
            System.out.println();
            traiangle(r - 1, 0);
        }

    }

    //sheedha triangle  2 it is similar to the bubble sort
// Straight Triangle
    static void triangle2(int r, int c) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            triangle2(r, c + 1);
            System.out.print("* ");
        } else {
            triangle2(r - 1, 0);
            System.out.println();
        }
    }
}

