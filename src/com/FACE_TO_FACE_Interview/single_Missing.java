package com.FACE_TO_FACE_Interview;

///this is called the cyclick sort
public class single_Missing {

    public class Cyclicsort {
        public static void main(String[] args) {
            int[] arr = {1, 2, 4, 5}; // missing 3
            int missing = findMissing(arr);
            System.out.println("Missing number: " + missing);
        }

        static int findMissing(int[] arr) {
            int i = 0;

            // cyclic sort
            while (i < arr.length) {
                int correctIndex = arr[i] - 1;

                if (arr[i] <= arr.length && arr[i] != arr[correctIndex]) {
                    swap(arr, i, correctIndex);
                } else {
                    i++;
                }
            }
            // find missing
            for (int index = 0; index < arr.length; index++) {
                if (arr[index] != index + 1) {
                    return index + 1;
                }
            }
            return arr.length + 1; // edge case
        }

        static void swap(int[] arr, int start, int end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }
}
