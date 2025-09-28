package com.Stack_Questions;

import java.util.Stack;

//https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/description/
public class MinInsertion_parathesis {

    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int insertions = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else { // c == ')'
                // Check if next character is also ')'
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    // Found "))" pair
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop(); // Perfect match: ( with ))
                    } else {
                        insertions++; // Need to insert '(' for this "))"
                    }
                    i++; // Skip the next ')' since we processed both
                } else {
                    // Single ')' found - need another ')' to complete the pair
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                        insertions++; // Insert one ')' to make "))"
                    } else {
                        insertions += 2; // Insert '(' and ')' to make "())"
                    }
                }
            }
        }

        // Each remaining '(' in stack needs "))"
        insertions += stack.size() * 2;

        return insertions;
    }

    /// second method
    public int minInsertionsClean(String s) {
        int insertions = 0;
        int rightNeeded = 0; // How many ')' are needed

        for (char c : s.toCharArray()) {
            if (c == '(') {
                rightNeeded += 2; // Each '(' needs two ')'

                // If rightNeeded is odd, we need to insert one ')' to make pairs
                if (rightNeeded % 2 == 1) {
                    insertions++;
                    rightNeeded--;
                }
            } else { // c == ')'
                rightNeeded--;

                // If rightNeeded becomes negative, we need to insert '('
                if (rightNeeded < 0) {
                    insertions++;
                    rightNeeded = 1; // Now we need one more ')'
                }
            }
        }

        return insertions + rightNeeded;
    }

    public static void main(String[] args) {
        MinInsertion_parathesis mip = new MinInsertion_parathesis();
        String s = "(()))";
        System.out.println(mip.minInsertions(s));
    }
}

