package com.stack;

import java.util.Stack;

public class Stckexampleone {
    public static void main(String[] args) {
        Stack <Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Stack: " + stack);//output- Stack: [1, 2, 3, 4, 5]

        stack.pop();
        stack.pop();
        System.out.println("Stack after pop: " + stack);//output- Stack after pop: [1, 2, 3]

    }



}
