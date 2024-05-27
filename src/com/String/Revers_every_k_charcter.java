package com.String;



/// https://leetcode.com/problems/reverse-string-ii/description/
/// in this question we have to reverse the first k charcter in reverseorder  and then skip the next k character
/// and then again reverse the next k charcter and so on
/// We are:
/// 	•	Moving in blocks of 2k
/// 	•	Reversing only first k inside each block
public class Revers_every_k_charcter {
    static String reverseEveryK(String str, int k) {
        if (str == null || k <= 1) return str;

        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i += 2 * k) {

            int left = i;
            int right = Math.min(i + k - 1, arr.length - 1);

            while (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        return new String(arr);
    }
}
