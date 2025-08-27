package com.recursion;

public class BalancedBracketsEfficient {
    public static void main(String[] args) {
        String s1 = "{[(])}";     // true
//        String s2 = "([{}])";     // true
//        String s3 = "({[)]}";     // false
//        String s4 = "((()))";     // true
//        String s5 = "{[(()])}";   // false

        System.out.println(isBalanced(s1)); // true
//        System.out.println(isBalanced(s2)); // true
//        System.out.println(isBalanced(s3)); // false
//        System.out.println(isBalanced(s4)); // true
//        System.out.println(isBalanced(s5)); // false
    }

    // Main function
    public static boolean isBalanced(String s) {
        return check(s, 0, s.length()) == s.length();
    }

    // Recursive function that returns the index after processing a balanced substring
    private static int check(String s, int i, int n) {
        while (i < n) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                // Find the matching closing bracket recursively
                int next = check(s, i + 1, n);
                if (next == -1 || next >= n) return -1;// no match found or out of bounds

                char close = s.charAt(next);
                if (!matches(ch, close)) return -1;

                i = next + 1; // move past closing bracket
            } 
            else if (ch == ')' || ch == '}' || ch == ']') {
                return i; // return position of closing bracket to caller
            } 
            else {
                i++; // ignore non-bracket characters
            }
        }
        return i;
    }

    // Matching pairs
    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}