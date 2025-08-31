package com.recusions_Array;

import java.util.ArrayList;

import static com.recusions_Array.Search_target_element.list;

public class Serch_In_array2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3, 6, 3};
        int target = 3;

        ArrayList<Integer> result = serch(arr, target, 0, new ArrayList<>());// Create a new ArrayList to store the indices
        System.out.println(result);

    }
    static ArrayList serch(int[] arr, int target,int index, ArrayList<Integer> list){
        if( index == arr.length){
            return list;
        }
        if(arr[index]==target){
            list.add(index);
        }
        return serch(arr, target, index+1, list);
    }
}
