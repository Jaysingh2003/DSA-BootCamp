package com.condition_loop;

import java.util.Scanner;

public class Largest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter three numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

//        int max = a;
//        if (b > max) {
//            max = b;
//        }
//        if (c > max) {
//            max = c;
//        }
//
//        System.out.println("Largest number is: " + max);
//        sc.close();


        //second way of doing this
        // math.max(a,b) :-gives the maximum value among the two of a,b
        int max=Math.max(c,Math.max(a,b));
        System.out.println(max);
    }
}