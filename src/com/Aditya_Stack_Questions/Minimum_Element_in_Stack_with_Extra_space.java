package com.Aditya_Stack_Questions;

import java.util.Stack;

/// Design a Special Stack that supports:
/// push()
/// pop()
/// getMin()

public class Minimum_Element_in_Stack_with_Extra_space {

    Stack<Integer> s = new Stack<>();

    // Support stack for minimum elements
    Stack<Integer> ss = new Stack<>();

    // Push element
    void push(int a) {

        s.push(a);

        // Push into support stack if:
        // 1. support stack empty
        // 2. current element smaller/equal
        if (ss.isEmpty() || ss.peek() >= a) {

            ss.push(a);
        }
    }

    // Pop element
    int pop() {

        if (s.isEmpty()) {
            return -1;
        }

        int res = s.pop();

        // Remove from support stack also
        if (res == ss.peek()) {

            ss.pop();
        }

        return res;
    }

    // Get minimum element
    int getMin() {

        if (ss.isEmpty()) {
            return -1;
        }

        return ss.peek();
    }

    public static void main(String[] args) {

        Minimum_Element_in_Stack_with_Extra_space st =
                new Minimum_Element_in_Stack_with_Extra_space();

        st.push(18);
        st.push(19);
        st.push(29);
        st.push(15);
        st.push(16);

        System.out.println("Minimum: " + st.getMin());

        st.pop();

        System.out.println("Minimum: " + st.getMin());

        st.pop();

        System.out.println("Minimum: " + st.getMin());
    }
}