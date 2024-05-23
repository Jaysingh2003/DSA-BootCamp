package com.Rising_Brain_Array_Pattern.Two_Pointer;

import java.util.Arrays;
import java.util.HashMap;

public class Two_Sum_Problem {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];

            if (map.containsKey(rem)) {
                return new int[]{map.get(rem), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Two_Sum_Problem t = new Two_Sum_Problem();

        int[] ans = t.twoSum(new int[]{2, 7, 11, 15}, 9);

        System.out.println(Arrays.toString(ans));
    }
}