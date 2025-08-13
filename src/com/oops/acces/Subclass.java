package com.oops.acces;

public class Subclass extends A {

    public Subclass(int num, String name) {
        super(num, name);
    }

    public static void main(String[] args) {
        Subclass obj1 = new Subclass(10, "jaysingh");
        int num = obj1.num; // Accessing public variable from superclass
        obj1.display(); // Call the display method to show the values
    }
    public void display() {
        // Accessing public variable directly
        System.out.println("Number: " + num);

        // Accessing public method from superclass
        //we can also access private variable from superclass
        System.out.println("Name: " + getName());

        // Cannot access private variable 'name' directly  but we can access the protected
         //System.out.println("Private Name: " + name);


        //here this refer to the obj1 because the loacl variable is not accesible outside the mathods
        System.out.println(this  instanceof Object); // every object is instace of object cl
    }


}
