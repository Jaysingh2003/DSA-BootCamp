package com.oops.Abstaction;

public class Son extends Parent {

        // Constructor to initialize age
        Son(int age) {
            super(age);
        }
        @Override
        void carreer() {
            System.out.println(" i am a Software Engineer");
        }

        @Override
        void partner( int age) {
            System.out.println( " alok is married at the age of  "+ this.age);
        }

}
