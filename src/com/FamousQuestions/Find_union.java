package com.FamousQuestions;

import java.util.HashSet;
import java.util.Set;

public class Find_union {
    public static int[] findUnion(int[] nums1, int[] nums2) {
        // Using HashSet to store unique elements because it automatically handles duplicates
        //and we have to preserve the order of elements  usethis--> Set<Integer> set = new TreeSet<>();
        Set<Integer> set = new HashSet<>();

        for (int n : nums1) set.add(n);
        for (int n : nums2) set.add(n);

        int[] result = new int[set.size()];
        int i = 0;
        for (int n : set) {
            result[i++] = n;
        }
        return result;
    }

}
