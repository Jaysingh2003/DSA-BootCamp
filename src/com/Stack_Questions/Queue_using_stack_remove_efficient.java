package com.Stack_Questions;

import java.util.Stack;

//remove efficient approach
public class Queue_using_stack_remove_efficient {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public Queue_using_stack_remove_efficient() {// constructor
        first = new Stack<>();
        second = new Stack<>();
    }

    public int remove(){
        return first.pop();
    }
    public int add(int val) {
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        first.push(val);//new value ke push ker do first stack me the second se fir first me push ker do
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return val;
    }

    public  int peek(){
        return first.peek();
    }

    public boolean empty() {
        return first.isEmpty();
    }
}
