package com.functions;

public class Changname {

    static void changevalue(String naam) {
        naam = "jay";
    }

    public static void main(String[] args) {
        String name = "kunal";
        changevalue(name);
        System.out.println(name); // Output will still be "kunal"
    }
}
