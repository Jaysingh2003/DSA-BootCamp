package com.functions;

public class Scope {

    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        String name = "jay";

        {
//            int a =10;//here we can reinialize the a we can only use the value of a
            a = 20;
            int c=13;
            System.out.println(a);
        }
        System.out.println(a);
//        System.out.println(c); can to use the outside os his scope
        int c = 99;//but we can intailize the c  outside
        System.out.println(c);


        //in array
        for (int i = 0; i < 4; i++) {
            int nom = 90;
            a = 10000;

        }
        System.out.println(a);
//        System.out.println(nom);//it ca not we scoped here



    }

};

