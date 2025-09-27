package com.Stack_Questions;

import java.util.Stack;
//https://leetcode.com/problems/implement-queue-using-stacks/submissions/1783882971/

//This is the insert efficient approach.... insert operation is 0(1) time complexity

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

    //in interview can ask
    //This is the remoce  efficient approach.... means 0(1) time complexity for remove operation
     //refer the Queue_using_stack_remove_efficient approach file
}
