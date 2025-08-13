package com.oops.inheritance;

public class Box {
    double length;
    double breadth;
    double height;

    Box() {
        this.length = -1;
        this.breadth = -1;
        this.height = -1;
    }
    public Box(double side) {
        this.length = side;
        this.breadth = side;
        this.height = side;
    }

    public Box(double length, double breadth, double height) {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }


}
