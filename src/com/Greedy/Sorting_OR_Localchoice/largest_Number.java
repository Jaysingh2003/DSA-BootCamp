package com.Greedy.Sorting_OR_Localchoice;

import java.util.Arrays;

public class largest_Number {

    public String largestNumber(int[] nums) {

        String[] arr = new String[nums.length];

        for (int i=0; i< nums.length ; i++){
            arr[i]=String.valueOf(nums[i]);// converting int to string
        }

        // sorting the array in descending order
         Arrays.sort(arr, (a,b)->(b+a).compareTo(a+b)); // comparing the concatenated string

        // if the largest number is 0, then return 0
        if (arr[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();

    }
}
