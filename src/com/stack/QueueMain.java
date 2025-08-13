package com.stack;

public class QueueMain {
    public static void main(String[] args) {

        CustomQueue queue = new CustomQueue(5);

        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        // queue.add(60); // This will throw an exception since the queue is full

        queue.display();
        queue.remove();

        queue.display();



    }
}
