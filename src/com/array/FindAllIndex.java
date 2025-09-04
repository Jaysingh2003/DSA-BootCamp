package com.array;

import java.util.ArrayList;

public class FindAllIndex {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3, 6, 3};
        int target = 3;

        System.out.println(findAllIndex(arr, target, 0));
    }

    static ArrayList<Integer> findAllIndex(int[] arr, int target, int index) {
        ArrayList<Integer> list = new ArrayList<>();
        if (index == arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls = findAllIndex(arr, target, index + 1);
        list.addAll(ansFromBelowCalls);
        return list;
    }

}
