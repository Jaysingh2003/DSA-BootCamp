package com.Rising_Brain_Array_Pattern.Two_Pointer;

import java.util.*;

public class Three_Pointer {
    public List<List<Integer>> threeeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = n - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                    while (l < r && nums[l] == nums[l - 1]) l++;///this will check that right abnd left not overlap and
                    while (l < r && nums[r] == nums[r + 1]) r--;////io eleemnt are equal then simply incrses the p[oint]
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
        Three_Pointer t = new Three_Pointer();
        System.out.println(t.threeeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

}
