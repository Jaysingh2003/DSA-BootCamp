package com.SerchingQuestions;
//https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
public class CielingOfNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 7, 23, 34, 45, 56, 67, 78};
        int target = 25;
        int ans = ceilingopfnumber(arr, target);
        System.out.println(ans);
    }

    static int ceilingopfnumber(int[] arr, int target) {

        if (target > arr[arr.length - 1]) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {//this will start just greater  than the middle element
                start = mid + 1;
            } else {
                end = mid - 1;
            }


        }
        return start;

    }
}
