package com.oops;

public class Finalkeyword {

    public static void main(String[] args) {
        final A kunal = new A("kunal");
        kunal.name="jay";
        System.out.println(kunal.name);


        //when a on primitive is final you can not ressign it a new value
        //kunal=new A("new name")
    }

    static class A{
        String name;

        A(String name){
            this.name=name;
        }
    }
}
