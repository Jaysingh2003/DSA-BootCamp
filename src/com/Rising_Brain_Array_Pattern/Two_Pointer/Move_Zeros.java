package com.Rising_Brain_Array_Pattern.Two_Pointer;


public class Move_Zeros {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
    public static void main(String[] args) {
        Move_Zeros mz = new Move_Zeros();
        int[] nums = {0, 1, 0, 3, 12};
        mz.moveZeroes(nums);
    }
}
