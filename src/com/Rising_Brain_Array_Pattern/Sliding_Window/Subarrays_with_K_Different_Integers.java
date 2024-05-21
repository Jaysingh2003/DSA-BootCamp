package com.Rising_Brain_Array_Pattern.Sliding_Window;

import java.util.HashMap;

/// https://leetcode.com/problems/subarrays-with-k-different-integers/description/
public class Subarrays_with_K_Different_Integers {
    /// Broute Forec
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i; j < n; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                if (map.size() == k) {
                    ans++;
                } else if (map.size() > k) {
                    break;
                }
            }
        }

        return ans;

    }

    /// Optimized approch VVI
    /// By defaoult the slideing window works of the the at most cahacter menas it will calculate the
    /// lestt that k wale casses so to  find the exactly
    /// text {Exactly K} = text At Most K} - text At Most (K-1)}-> k-1 karne se ke se kam wale saare case remove ho jayenge
    /// answer = atMost(k) - atMost(k - 1);
    public int subarraysWithKDistinctII(int[] nums, int k) {
        int left = 0;
        int n = nums.length;
        int ans = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);///put the element in the map
            if (map.size() > k) {
                while (map.size() > k) {
                    map.put(nums[left], map.get(nums[left]) - 1);

                    if (map.get(nums[left]) == 0) {///this case checkif the frequency of the left is zero if zero the left ko age badhao
                        map.remove(nums[left]);
                    }
                    left++;
                }
            }
            count += right - left + 1;
        }
        return count;

    }
    ///this fxn will hepl tp calculate the exaclty k casses becapuse by defoult in the sliding window be included
    ///  the casses  at most k and k se kam size wale so remove karne ke liye un casses ko
    /// answer = atMost(k) - atMost(k - 1); kuki k-1 karne se less than size k wale casses rrmove ho jayuenge and hame exaclty
    /// size == k wale mil jayenge
    ///
    public int slidingWindow(int[] nums, int k){//
        return subarraysWithKDistinctII(nums, k) - subarraysWithKDistinctII(nums, k - 1);
    }
}
