package com.functions;

public class Shadowing {
    static int a =100;//here  will we shadowed

    public static void main(String[] args) {
        System.out.println(a);//100

        int a =20;
        System.out.println(a);//20
    }

}
