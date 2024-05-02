package com.Aditya_Stack_Questions;

import java.util.*;

///in this problem we have to find the nearest smaller element to the left of the current element
/// ex-
/// arr = [1,3,2,4]
/// op = [-1,1,1,2]
public class Nearest_Smaller_To_Left {

    public static void nearestSmallerToLeft(int[] arr) {

        int n = arr.length;

        Stack<Integer> st = new Stack<>();

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

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

        System.out.println(ans);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        nearestSmallerToLeft(arr);
    }
}