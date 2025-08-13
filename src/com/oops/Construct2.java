package com.oops;

public class Construct2 {



    static class Student {
        int rollno;
        String name;
        float marks = 90;

        //ww can call the one cosntuctor to the anther constirtor
        //inetenall: new Student (23,"default person",34.5f)
        Student(){
         this(23,"default person",34.5f) ;
        }

        Student(String name) {
            this.name = name;
        }
        //Student jay = new jay(23,jaysingh,87.0)
        //here the this  keyword is replace with the jay
        Student(int rollno, String name, float marks) {
            this.rollno = rollno;
            this.name = name;
            this.marks = marks;
        }

        void greetings(){
            System.out.println("Hello my name is "+ this.name);
        }
    }

    public static void main(String[] args) {
//        Student[] student = new Student[5];
        //Student s1 = new Student() ;
        Student s1 = new Student(102,"jay",95.5f);
        Student s2 = new Student("karan");
        System.out.println(s2.name);
        //output of the one canstructor called to the another one
        Student s3=new Student();
        System.out.println(s3.name);

        //we can do it by the use of the constructor

//         s1.rollno = 101;
//        s1.name = "kunal";
//        s1.marks = 99.9f;
        s1.greetings();
        System.out.println(s1);//it will print->  com.oops.Classexamplke$Student@30f39991  why?
        System.out.println(s1.rollno);
        System.out.println(s1.name);
        System.out.println(s1.marks);


    }
}
