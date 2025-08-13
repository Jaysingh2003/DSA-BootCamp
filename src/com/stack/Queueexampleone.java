package com.stack;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Queueexampleone {
    public static void main(String[] args) {
//        Queue<Integer> queue  = new ArrayDeque<>();
      //we can use the ArrayDeque for the queue implementation becouse its faster than LinkedList and no size issue
        Queue<Integer> queue =  new ArrayDeque<>();
        // Adding elements to the queue
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);

        // Displaying the queue
        System.out.println("Queue: " + queue);
        // Removing elements from the queue
        System.out.println("Removed element: " + queue.remove());
        System.out.println("Queue after removal: " + queue);
        System.out.println("Peek at the front element: " + queue.peek());


    }
}
