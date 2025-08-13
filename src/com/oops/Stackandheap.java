package com.oops;

public class Stackandheap {






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
//
            //concept of the heap memory that both the object wi ll point to the same object
            Student one = new Student();
            Student two = one;
            one.name="somthing sonthing";
            System.out.println(two.name);

        }
    }
