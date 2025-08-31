package com.recusions_Array;

import java.util.ArrayList;

public class Search_target_element {
    public static void main(String[] args) {
        int[] arr = {1, 27, 33, 56, 7, 7, 8, 9};
        int target = 7;
        System.out.println(search(arr, target, 0));
        System.out.println(searchIndex(arr, target, 0));
        System.out.println(searchLastIndex(arr, target, arr.length - 1));
        searchAllIndex(arr, target, 0);
        System.out.println(list);
    }

    // Questions-1 if the target element is present or not
    static boolean search(int[] arr, int target, int index) {
        if (index == arr.length) {
            return false;
        }
        return (arr[index] == target) || search(arr, target, index + 1);
    }

    // Questions-2 if we want to find the index of target element
    static int searchIndex(int[] arr, int target, int index) {
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        }
        return searchIndex(arr, target, index + 1);
    }

    // Questions-3 from the last index
    static int searchLastIndex(int[] arr, int target, int index) {
        if (index == -1) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        }
        return searchLastIndex(arr, target, index - 1);
    }

    // Questions-4 find all the index of target element
    // Approach-1 using static arraylist

    static ArrayList<Integer> list = new ArrayList<>();

    static void searchAllIndex(int[] arr, int target, int index) {
        if (index == arr.length) {
            return;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        searchAllIndex(arr, target, index + 1);
    }

}