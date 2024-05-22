package com.Rising_Brain_Array_Pattern.Two_Pointer;


/// https://leetcode.com/problems/trapping-rain-water/description/
public class Trapping_Rainwater {
    /// broute force;
    /// in this we calculate the for everindex the lefttmost and rightmost height and then subtract the
    public int trapWater(int[] height) {
        int res = 0;
        for (int i = 1; i < height.length; i++) {
            int left = height[i];
            for (int j = 0; j < i; j++) {///left side ka 0 to j tak ki hight
                left = Math.max(left, height[j]);
            }
            int right = height[i];
            for (int j = i + 1; j < height.length; j++) {/// j-1 to last take ki hight calculate karna
                right = Math.max(right, height[j]);
            }
            res += Math.min(left, right) - height[i];
        }
        return res;

    }

    //optimiozed approch
    public int trappedWater(int[] height) {
        int left = 0;
        int right = height.length-1;

        int water = 0;
        int leftmax = 0;
        int rightmax = 0;

        while (left < right) {//first we check the left side if left is samlller then we calculate  from the right side;
            if (height[left] <= height[right]) {
                left++;
                leftmax = Math.max(leftmax, height[left]);
                water += leftmax - height[left];
            } else {///right side height is more
                rightmax = Math.max(rightmax, height[right]);
                water += rightmax - height[right];
                right--;
            }
        }
        return water;
    }
}
