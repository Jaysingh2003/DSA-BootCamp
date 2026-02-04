package com.Stack_Questions;

import java.util.Stack;

public class Queue_using_Stack {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Enqueue operation
    //complexity O(n)

    // ther are three step
    // copy the elements from s1 to s2
    // add the new element to s1
    // copy back all the elements from s2 to s1
    public void enqueue(int data) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(data);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // Dequeue operation
    //complexity O(1)
    public int dequeue() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return s1.pop();
    }

    //top operation
    //complexity O(1)
    public int top() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return s1.peek();
    }

    // Check if the queue is empty
    //complexity O(1)
    public boolean isEmpty() {
        return s1.isEmpty();
    }
}
