package com.searching;

public class Linerasearch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 89, 8, 0, 77, 754};
        int target = 89;
        int ans = sersch(nums, target);
        System.out.println(ans);
    }

    static int sersch(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }

      //  for  each loop
//        for(int element: arr){
//            if(element==target){
//                return element;
//            }
//        }
        for (int index = 0; index < arr.length; index++) {
            int element = arr[index];
            if (element == target) {
                return index;
            }

        }

     return -1;
    }

}
