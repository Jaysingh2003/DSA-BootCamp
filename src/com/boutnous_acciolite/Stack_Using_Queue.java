package com.boutnous_acciolite;

import java.util.LinkedList;
import java.util.Queue;

//Note  in queue when we add the element is added at the end and removalis from the front
//in stack when we add the element is added at the top and removalis from the top
/// ther are three step
/// copy the elements from q1 to q2
/// add the new element to q1
/// copy back all the elements from q2 to q1
///
public class Stack_Using_Queue {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push elements onto stack
    //complexity O(n)
    public void push(int data) {
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        q1.add(data);
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
    }

    // Remove the top element from stack
    //complexity O(1)
    public int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.remove();
    }

    // Get the top element of stack
    public int top() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.peek();
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }

}
