package com.Stack_Questions;

import java.util.Stack;

public class Queue_using_stack {

    private Stack<Integer> first;
    private Stack<Integer> second;

    public Queue_using_stack() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void add(int val) {
        first.push(val);
    }

    public int remove() throws Exception {
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        int removed= second.pop();
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return removed;
    }

    //peak is the first element that will be removed from the queue
    public int peek() {//the item that will removed from the queue first will e tyhe first element
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        int peeked= second.peek();
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return peeked;

    }
    public boolean empty() {
        return first.isEmpty();
    }
}
