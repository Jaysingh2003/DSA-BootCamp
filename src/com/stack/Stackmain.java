package com.stack;

import java.lang.reflect.Array;
import java.util.Arrays;
public class Stackmain {
    public static void main(String[] args) throws StackExceptions {
//        CustomStack customStack = new CustomStack(5);
        // Using DynamicStack to demonstrate dynamic resizing
       CustomStack customStack = new Dynamicstack(5);


        // Push elements onto the stack
        customStack.push(10);
        customStack.push(20);
        customStack.push(30);
        customStack.push(400);
        customStack.push(50);
        customStack.push(60); // This will trigger dynamic resizing
        customStack.push(70); // This will also trigger dynamic resizing


        // Display the top element we use this because we handled the exceptions

//        if(customStack.isEmpty()){
//            System.out.println("Stack is empty, cannot peek.");
//        } else {
//            try {
//                System.out.println("Top element: " + customStack.peek());
//            } catch (StackExceptions e) {
//                System.out.println(e.getMessage());
//            }
//        }


        // Pop an element from the stack
        System.out.println("Popped element: " + customStack.pop());
        System.out.println("Popped element: " + customStack.pop());
        System.out.println("Popped element: " + customStack.pop());
        System.out.println("Popped element: " + customStack.pop());
        System.out.println("Popped element: " + customStack.pop());


    }
}
