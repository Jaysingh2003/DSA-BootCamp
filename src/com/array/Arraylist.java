package com.array;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Arraylist {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>(10);

        for (int i = 0; i <5 ; i++) {
            list.add(input.nextInt());
        }
        System.out.println(list);


        for (int i = 0; i <5 ; i++) {
            System.out.println(list.contains(4));
        }


    }
}
