package com.sorting.cyclicsort_question;

//if the no is from the 0 ti n the here total  (n+1) elemnt in the array
//missing no means we have to find the element which are not at their corrcet index thar are the missing numbers.
public class Missing_number {

    public static int findduplicate(int[] arr) {
        int index = 0;
        while (index < arr.length) {
            int corrcet = arr[index];//it means the index and the value at that index is same.
            ///case-1 if the no at any index is grateter than the total n then ignore it
            ///  cse-2 if the index and the number at the index  is equal then the return the index of last
            if (arr[index] < arr.length && arr[corrcet] != arr[index]) {
                swap(arr, index, corrcet);
            } else {
                index++;
            }

        }///now search for the missing number...
        for (int j = 0; j < arr.length; j++) {
            if (arr[index] != index) {//means if the index is not eaqal the we have to retun the element aty that index
                return arr[index];
            }
        }
        return arr.length;

    }
    static void swap(int[] arr, int fisrt, int second) {
        int temp = arr[fisrt];
        arr[fisrt] = arr[second];
        arr[second] = temp;
    }
}
