package com.TWOPOINTER;

import java.util.ArrayDeque;
import java.util.Deque;

public class First_negative_m_number {

    public static void negativeNumber(int[] arr, int k) {
        int i = 0, j = 0;
        int n = arr.length;

        Deque<Integer> dq = new ArrayDeque<>(); // store INDEXES

        while (j < n) {

            // 1️⃣ calculation
            if (arr[j] < 0) {
                dq.addLast(j);   // store index
            }

            // 2️⃣ window size not hit
            if (j - i + 1 < k) {
                j++;
            }

            // 3️⃣ window size hit
            else if (j - i + 1 == k) {

                // answer
                if (dq.isEmpty()) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(arr[dq.peekFirst()] + " ");
                }

                // 4️⃣ remove element going out of window
                //  dq.peekFirst() it will return index of first negative number in the dq(becouse we are storing index in dq)
                //it means ki jo dq me hum store ker rakhe hai wo index i ke barabar hai to hum usko dq se remove ker denge
                if (!dq.isEmpty() && dq.peekFirst() == i) {// if index matches it manes the
                    dq.pollFirst();
                }

                // slide window
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