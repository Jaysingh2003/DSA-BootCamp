package com.FamousQuestions;

import java.util.HashSet;

//One set tracks seen elements
//Another set stores duplicates (to avoid repetition)
public class Find_duplicate_element {
    public static int[] findDuplicates(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> dup = new HashSet<>();

        for (int num : arr) {
            if (!seen.add(num)) {//seen.add(num) returns false if num is already present and thus !seen.add(num) will be true so that the code inside if block will execute
                dup.add(num);//add to dup set if duplicate found
            }
        }

        int[] result = new int[dup.size()];
        int index = 0;
        for (int num : dup) {
            result[index++] = num;
        }

        return result;
    }
}
