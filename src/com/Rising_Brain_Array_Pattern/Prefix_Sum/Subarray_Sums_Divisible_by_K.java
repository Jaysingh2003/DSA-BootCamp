package com.Rising_Brain_Array_Pattern.Prefix_Sum;
import java.util.HashMap;
/// optimizes approch
//we have to use the prefix sum because the we have to perfoem the oipertion on each continous saubarray sum


public class Subarray_Sums_Divisible_by_K {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefixSum = 0;
        int result = 0;

        for (int num : nums) {
            prefixSum += num;
            int mod = prefixSum % k;
            if (mod < 0) {///-1 % 5 = -1   and
                mod += k;         /// -1 + 5 = 4 this is the correct mod
            }
            result += map.getOrDefault(mod, 0);///if the
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return result;
    }
    public static void main(String[] args) {
        Subarray_Sums_Divisible_by_K s = new Subarray_Sums_Divisible_by_K();
        System.out.println(s.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }
}
