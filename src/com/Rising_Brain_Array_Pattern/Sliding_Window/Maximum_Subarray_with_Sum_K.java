package com.Rising_Brain_Array_Pattern.Sliding_Window;
///https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
public class Maximum_Subarray_with_Sum_K {
    public int maxArraySum(int[] arr,int k) {
        int i = 0;
        int j = 0;
        int windowSum = 0;
        int answer = Integer.MIN_VALUE;
        int n = arr.length;
        while (j < n) {
            windowSum += arr[j];
            if (j - i + 1 < k) {
                j++;
            } else {///(j-i+1=k ) this is the condition
                answer = Math.max(answer, windowSum);
                // Remove the leftmost element
                windowSum -= arr[i];
                i++;
                j++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Maximum_Subarray_with_Sum_K m=new Maximum_Subarray_with_Sum_K();
        System.out.println(m.maxArraySum(new int[]{2,3,5,6,7,8},3));

    }
}
