package com.Stack_Questions;

import java.util.Stack;

//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/submissions/1785186968/
public class CountParathesis {
    Stack<Character> stack = new Stack<>();

    public int countUnmatchedParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c==')'){
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                } else {
                    stack.push(c);

                }
            }else {
                stack.push(c);
            }

        }
        return stack.size();
    }



    public static void main(String[] args) {
        CountParathesis cp = new CountParathesis();
        String s = "((())";
        System.out.println(cp.countUnmatchedParentheses(s));
    }


///    another method

//    public int countUnmatchedParentheses2(String s) {
//        Stack<Character> stack = new Stack<>();
//        int unmatchedClosing = 0;
//
//        for (char c : s.toCharArray()) {
//            if (c == '(') {
//                stack.push(c);
//            } else if (c == ')') {
//                if (!stack.isEmpty()) {
//                    stack.pop(); // Match found, remove opening parenthesis
//                } else {
//                    unmatchedClosing++; // No matching opening parenthesis
//                }
//            }
//        }
//
//        // Total unmatched = unmatched closing + unmatched opening (remaining in stack)
//        return unmatchedClosing + stack.size();
//    }
//
}