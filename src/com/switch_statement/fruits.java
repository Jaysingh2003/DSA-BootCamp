package com.switch_statement;

import java.util.Scanner;

public class fruits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


//        switch (fruits) {
//
//            //this is the enhanced swith
//
//            case "mango" -> System.out.println("kin gpf frutsts");
//            case "apple" -> System.out.println("one apple  day");
//
//
//        }/

        int day = sc.nextInt();
        switch (day){
            case (1):
                System.out.println("monday");
                break;

            case (2):
                System.out.println("tuesday");
                break;

            case (3):
                System.out.println("wednesday");
              break;
            case(4) :
                System.out.println("thursday");



        }
    }



}
