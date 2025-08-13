package com.stack;

import java.util.Stack;

public class CustomStack {
    public int[] stack; // Array to hold stack elements means jo custumstack ham banyege
    private int top;// Index of the top element in the stack means jo stack ke top element ka index hoga
    protected int capacity; // Maximum capacity of the stack

    // Constructor

    public CustomStack() {

    }

    public CustomStack(int size) {
        this.stack = new int[size];
        top = -1;
        capacity = size;
    }


    // Push operation
    public boolean push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + x);
            return false;
        }
        top++;
          stack[top] = x; // Increment top and add the element
        return true;
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Nothing to pop");
            return -1;
        }
        return stack[top--];
    }

    // Peek operation
    public int peek() throws StackExceptions {
        if (isEmpty()) {
            throw new StackExceptions("Stack is empty! Cannot peek");
        }
        return stack[top];
    }

    // Check if empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Size
    public int size() {
        return top + 1;
    }
}