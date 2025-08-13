package com.oops.inheritance;

public class Main {
    public static void main(String[] args) {
        Box box1 = new Box();
        Box box2 = new Box(5);
        System.out.println("Box 1 dimensions: " + box2.length + " x " + box2.breadth + " x " + box2.height);

//        Box box3 = new Boxweight(5, 5, 5, 10);
//        System.out.println(box3.weight);

        // The following line will cause a compile-time error because Box does not have a weight attribute

        //Boxweight box4 = new Box(5, 5, 5);

    }
}
