package com.Aditya_Stack_Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair1 {

    int index;
    int value;

    Pair1(int value, int index) {
        this.index = index;
        this.value = value;
    }
}

public class Stock_Span_Problem {

    public int[] consequtive_Equal_or_Smaller(int[] arr) {
        Stack<Pair1> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            // No greater element on left
            if (stack.isEmpty()) {
                list.add(-1);
            }
            // Greater element found
            else if (stack.peek().value > arr[i]) {
                list.add(stack.peek().index);
            }
            // Pop smaller/equal elements
            else {
                while (!stack.isEmpty() &&
                        stack.peek().value <= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    list.add(-1);
                } else {
                    list.add(stack.peek().index);
                }
            }
            stack.push(new Pair1(arr[i], i));
        }
        return answer(list);
    }
    static int[] answer(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = i - list.get(i);
        }
        return arr;
    }
}