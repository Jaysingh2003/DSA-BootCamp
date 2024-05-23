package com.Rising_Brain_Array_Pattern.Two_Pointer;


/// /https://leetcode.com/problems/container-with-most-water/description/


public class container_with_most_water {
    //Brouteforec:

    public int mostwater(int[] height) {
        int maxwater = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int h = Math.min(height[i], height[j]);
                int width = j - i;
                int currentwater = h * width;
                maxwater = Math.max(maxwater, currentwater);
            }
        }

        return maxwater;

    }

    //optimized usin two pointer:-
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(currentArea, maxArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        container_with_most_water cwmw = new container_with_most_water();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(cwmw.maxArea(height));
    }
}
