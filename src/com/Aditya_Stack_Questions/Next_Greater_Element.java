package com.Aditya_Stack_Questions;

//in this question we have to fine the next greater element from a give array.

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

///For every element in the array, find the first greater element on its right side.
public class Next_Greater_Element {

    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                list.add(-1);
            } else if (stack.peek() > arr[i]) {
                list.add(stack.peek());
            }
                  //is this condition when the top is not grater then we have to pop whicl pop we have totwo condition
//                eitherb empty of we getbthe element then we have to evaluate  which condition is satisfied
//                       according to that we add the ellemnt in the list.
            else {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    list.add(-1);
                } else {
                    list.add(stack.peek());
                }
            }

            stack.push(arr[i]);

        }
        return reverse(list, n);


    }
    static int[] reverse(List<Integer> list, int n){
        int[] arr = new int[list.size()];
        int j = 0;
        for (int i = n - 1; i >= 0; i--) {
            arr[j] = list.get(i);
            j++;
        }
        return arr;
    }

    public static void main(String[] args) {
         int[] arr = {1,3,2,4};
         int[] ans = nextGreaterElement(arr);
         for (int i = 0; i <ans.length ; i++) {
             System.out.print(ans[i] + " ");
         }



    }


}
