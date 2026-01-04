package com.TWOPOINTER;

import java.util.ArrayDeque;
import java.util.Deque;

public class First_negative_m_number {
    public static void negativeNumber(int[] arr, int k) {
        int i = 0, j = 0;
        int n = arr.length;
        Deque<Integer> dq = new ArrayDeque<>();
        while (j < n) {
            if (arr[j] < 0) {
                dq.addLast(arr[j]);
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (dq.isEmpty()) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(dq.peekFirst() + " ");

                }
                if(!dq.isEmpty() && dq.pollFirst()==i){
                    dq.pollFirst();
                }
                i++;
                j++;
            }
        }

    }
    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        negativeNumber(arr, k);
    }
}
