package com.Stack_Questions;

import java.util.Stack;

public class ValidParthesis {
    public  static  boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }


        }
       return  stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([)]{}";
        System.out.printf( isValid(s) ? "Valid" : "Not Valid" );

    }
}
