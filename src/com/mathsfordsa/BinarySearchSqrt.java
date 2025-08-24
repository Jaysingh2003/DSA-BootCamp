package com.mathsfordsa;

import com.sun.source.tree.BreakTree;

public class BinarySearchSqrt {
    public static void main(String[] args) {
        int n = 37;
        int p = 3;//precision
        System.out.printf("%.3f", sqrt(n, p));//3 decimal place
    }

    static double sqrt(int n, int p) {//p is the precision
        int low = 1;
        int high = n;
       double root = 0.0;

        while ((low <= high)) {
            int mid = low + (high - low) / 2;
            if (mid * mid == n) {
                return mid;
            }
            if (mid * mid < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        //logic for decimal point
        double inc = 0.1;//increment by 0.1,0.01,0.001
        for (int i = 0; i <= p; i++) {
            while (root * root <= n) {
                root = root + inc;
            }
            root = root - inc;
            inc = inc / 10;


        }
        return root;
    }

}
//complexity O(log n + p)  where p is the precision