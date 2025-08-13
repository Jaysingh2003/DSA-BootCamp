package com.oops.inheritance;

public class Boxweight extends Box {
    double weight;


    // Constructor with three parameters
    public Boxweight(double length, double breadth, double height, double weight) {
        super(length, breadth, height); // Calls the constructor of Box with three parameters
        this.weight = weight;
    }


}
