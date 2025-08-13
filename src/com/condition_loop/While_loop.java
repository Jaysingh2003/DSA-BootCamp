package com.condition_loop;

import java.util.Scanner;

public class While_loop {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int num = sc.nextInt();

        //while loop
//        int i = 1;
//        while(i<=num){
//            System.out.println("hello");
//            i++;
//        }

        //do while loop

        int i=0;
        do{
            System.out.println(i);
            i++;
        }while(i<=num);
    }
}
