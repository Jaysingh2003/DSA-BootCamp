package com.Aditya_Stack_Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

///Your code for Nearest Smaller to Right is correct.
///  only this lone and revsre is chnaaged -> for (int i = n - 1; i >= 0; i--)
public class Nearest_Smaller_to_Right {
    public static int[] nearestSmallerToRight(int[] arr) {

        int n = arr.length;

        Stack<Integer> st = new Stack<>();

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = n-1; i >=0 ;i--) {

            // If stack empty
            if (st.size() == 0) {
                ans.add(-1);
            }

            // If top smaller than current
            else if (st.peek() < arr[i]) {
                ans.add(st.peek());
            }

            // Pop greater/equal elements
            else {

                while (st.size() > 0 && st.peek() >= arr[i]) {
                    st.pop();
                }

                if (st.size() == 0) {
                    ans.add(-1);
                } else {
                    ans.add(st.peek());
                }
            }

            // Push current element
            st.push(arr[i]);
        }
        return reverse(ans);


    }
    static  int[] reverse(List<Integer> list){
        int[] arr = new int[list.size()];
        int k = 0;
        for (int i = list.size()-1; i>=0 ; i--) {
            arr[k++] = list.get(i);
        }
        return arr;

    }

}
