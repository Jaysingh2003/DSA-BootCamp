package com.sorting.cyclicsort_question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//if the no is from the 0 to n
public class Find_all_missing_no {
    public static List<Integer> findduplicate(int[] arr) {
        List<Integer> list = new ArrayList<>();//beacouse the answer may have not the fixed size;
        int index = 0;
        while (index < arr.length) {
            int corrcet = arr[index];//it means the index and the value at that index is same.
            ///case-1 if the no at any index is grateter than the total n then ignore it
            ///  cse-2 if the index and the number at the index  is equal then the return the index of last
            if (arr[index] < arr.length && arr[corrcet] != arr[index]) {/// if there is negative no thn we can ignore it  by (arr[index] >0) in && condtion
                swap(arr, index, corrcet);
            } else {
                index++;
            }

        }///now search for the missing number...
        for (int j = 0; j < arr.length; j++) {
            if (arr[index] != index) {//means if the index is not eaqal the we have to retun the element aty that index
               list.add(arr[index]);//add the va;ur of the index in the list
            }
        }
        return list;

    }
    static void swap(int[] arr, int fisrt, int second) {
        int temp = arr[fisrt];
        arr[fisrt] = arr[second];
        arr[second] = temp;
    }
}
