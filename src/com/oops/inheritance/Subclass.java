package com.oops.inheritance;

import com.oops.acces.A;

public class Subclass extends A {

    public Subclass(int num, String name) {
        super(num, name);
    }

    public static void main(String[] args) {
        Subclass obj = new Subclass(10, "jaysingh");
        obj.display(); // Call the display method to show the values
    }
    public void display() {
        // Accessing public variable directly
        System.out.println("Number: " + num);

        // Accessing public method from superclass
        //we can also access private variable from superclass
        System.out.println("Name: " + getName());

        // Cannot access private variable 'name' directly but we can acces the protected variable
         //System.out.println("Private Name: " + name); // This line would cause an error
    }


}
