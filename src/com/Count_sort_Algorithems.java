package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//in a count sort  we cont the number of digit and then compare,  it start from the start from the unit place the tens then hundreds and son on

/// Counting Sort is NOT comparison-based (vvi) // and  Works only for non-negative integers and //is suitabke of small range  array.
/// “Counting Sort works by counting frequencies of elements instead of comparing them,
///  and then reconstructing the sorted array using those frequencies.”
/// O(n + k)-time complexity where n = number of elements and k = range of numbers (max value).
/// O(k)-space complexity
public class Count_sort_Algorithems {

    public void countsort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Handle empty array case
        }
        /// Find the maximum element in the input array to determine the size of the count array
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Create count array to store the frequency of each unique object
        int[] count = new int[max + 1];
        for (int element : arr) {
            count[element]++;
        }

        // Build the output array make chnagring the original array to sorted order
        int index = 0;///we start from the first index
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {///i check if the element is present in the count array and if it is present then we add it to the original array and decrease the count of that element in the count array
                arr[index] = i;
                index++;
                count[i]--;
            }
        }

    }


    /// CountSortUsingHashMap another way. andot works in negative numbers and also works for large range of numbers
    public static void countSort(int[] arr) {

        if (arr == null || arr.length <= 1) {
            return; // Handle empty array case
        }


        ///step-1 to find the maximum element
        int max = Arrays.stream(arr).max().getAsInt();

        ///step-2 to count the frequency of each element in the array using HashMap
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);///to count the frequency of each element in the array
        }

        ///step-3 to reconstruct the sorted array using the frequency count from the HashMap
        int index = 0;
        for (int i = 0; i <= max; i++) {
            if (map.containsKey(i)) {
                int count = map.get(i);
                for (int j = 0; j < count; j++) {
                    arr[index] = i;///to add the element to the original array in sorted order
                    index++;
                }
            }

        }
    }


}
