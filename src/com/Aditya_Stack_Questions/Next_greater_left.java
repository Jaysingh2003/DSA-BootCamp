package com.Aditya_Stack_Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

///In this problem, for every element, we find the nearest greater element on the left side.
///
///the only change line ofr the right or next grater elemnt is that
///  we start loop for the left end and go toward right and also no need the reverse the lement it's alsrdy sorted
/// for (int i = n - 1; i >= 0; i--) (For Right Problems) (Right → Left)   ->>>>    for (int i = 0; i < n; i++) (For Left Problems) (Left → Right)
public class Next_greater_left {
    public static List<Integer> nextGreaterElement_Left(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <n; i++) {/// Note 1- only this line will change we have to mav form the left to right
            if (stack.isEmpty()) {
                list.add(-1);
            } else if (stack.peek() > arr[i]) {
                list.add(stack.peek());
            } else {
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
        return  list;/// Note 1- there is no need  fir the reverse of the list

    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        List<Integer> ans = nextGreaterElement_Left(arr);
        System.out.println(ans);
    }

}

