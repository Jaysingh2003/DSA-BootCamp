package com.SerchingQuestions;

public class FloorOfNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 7, 23, 34, 45, 56, 67, 78};
        int target = 6;
        int ans = floorofnumber(arr, target);
        System.out.println(ans);
    }

    static int floorofnumber(int[] arr, int target) {

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
        return end;
    }
}
