package com.Stack_Questions;

import java.util.Stack;

public class Largest_Rectangle_Histogram {

    public int lrragest_Ractangle(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        stack.push(0);
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {//if its ane wala bars small then calculate the area
                maxArea = getMax(heights, stack, maxArea, i);

            }
            stack.push(i);//Always push current index after processing

        }

       // For each remaining bar, calculates the area assuming its right boundary is at the end (n). Updates maxArea if a larger area is found.
        int n = heights.length;
        while (!stack.isEmpty()) {//for all the remaining bars in the stack assume its right boundry is last i.e (n)
            maxArea = getMax(heights, stack, maxArea, n);
        }

        return maxArea;//return the max area
    }

    public int getMax(int[] heights, Stack<Integer> stack, int maxArea, int i) {
        int area;
        int poppedIndex = stack.pop();//The poppedIndex represents the index of the bar whose height is being processed.
        if (stack.isEmpty()) {
            area = heights[poppedIndex] * i;//if stack is empty means the popped index is the smallest bar so area is height * width (i)
        } else {
            area = heights[poppedIndex] * (i - stack.peek() - 1);//if stack is not empty means the popped index is not the smallest bar so area is height * width
        }//The left boundary for this rectangle is determined by the new top of the stack (stack.peek()),
        // and the right boundary is at index i. The width is calculated as (i - stack.peek() - 1).
       // the rectangle spans only the bars between stack.peek() + 1 and i - 1.
        // This gives the correct number of bars for the rectangle's width

        return Math.max( maxArea, area);

    }
}

//complexity O(n) for time and O(n) for space