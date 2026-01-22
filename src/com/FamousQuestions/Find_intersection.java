package com.FamousQuestions;

import java.util.*;

public class Find_intersection {
    public static int[] findIntersection1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];

        Map<Integer, Integer> freq = new HashMap<>();

        // Count frequency of nums2
        for (int num : nums2) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        // Match with nums1
        for (int num : nums1) {
            if (freq.getOrDefault(num, 0) > 0) {
                result.add(num);
                freq.put(num, freq.get(num) - 1);
            }
        }

        // Convert List to array
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    //using the two pointer approach+sorting

    public static int[] findIntersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        // Convert List to array
        int[] ans = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            ans[k] = result.get(k);
        }

        return ans;
    }
}
