package com.oops;

public class Staticexample {
    static String school ="bbs";
    String name;


    //constructor
    public Staticexample(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Staticexample s1=new Staticexample("jay");
        Staticexample s2=new Staticexample("kunal");
        //note the static variable must be accessed with the classname not the instance variable name ;
        System.out.println(Staticexample.school);
        System.out.println(Staticexample.school);
    }
}
