package com.stack;

public class CirculerqueueMain {
    public static void main(String[] args) {
//        CirculkerQueue queue = new CirculkerQueue(5);
        Dynamiccirculerqueue queue = new Dynamiccirculerqueue(5);


        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(40);
        queue.add(50);
        queue.add(70); // This will trigger dynamic resizing

        // queue.add(60); // This will throw an exception since the queue is full

        queue.display();
        System.out.println( queue.remove());
        queue.display();

    }
}
