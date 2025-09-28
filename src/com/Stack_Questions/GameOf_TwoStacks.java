package com.Stack_Questions;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/game-of-two-stacks/problem
public  class GameOf_TwoStacks {
    //using the recursion we can do it

    public static int twoStacks(int x, int[] a, int[] b) {
        return twoStacksHelper(x, a, b, 0, 0) - 1;
    }

    public static int twoStacksHelper(int x, int[] a, int[] b, int sum, int count) {
        if (sum > x) {
            return count - 1; // Return previous valid count
        }
        if (a.length == 0 && b.length == 0) {
            return count;
        }

        int countA = 0, countB = 0;

        if (a.length > 0) {
            countA = twoStacksHelper(x, Arrays.copyOfRange(a,1,a.length), b, sum + a[0], count + 1);
        }
        if (b.length > 0) {
            countB = twoStacksHelper(x, a, Arrays.copyOfRange(b,1,b.length), sum + b[0], count + 1);
        }

        return Math.max(Math.max(countA, countB), count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

    }

}
