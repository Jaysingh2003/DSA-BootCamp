package com.Rising_Brain_Array_Pattern.Sliding_Window;

import java.util.Deque;
import java.util.LinkedList;
/// https://leetcode.com/problems/sliding-window-maximum/description/
public class Sliding_Window_Maximum {
    /// Broute force
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];///becouse yahi takmcheck ker sakte bak last me apne app hi jayega
        for (int i = 0; i <= n - k; i++) {
            int max = nums[i];
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            ans[i] = max;
        }
        return ans;
    }

    /// optimzed approch
    public int[] maxSlidingWindowII(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        Deque<Integer> dq = new LinkedList<>();
        for (int right = 0; right < n; right++) {

            //////the left side  of the dq  out of bound ho to jab tak bound me na aye tab take remoive karna h
            while (!dq.isEmpty() && dq.peekFirst() <= right - k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[right]) {
                dq.pollLast();
            }

            dq.addLast(right);
            if (right >= k - 1) {///jaise hi k-1 length hit kareng rtab ham answer me aave kareneg o bhi first element ko peek ke
                res[right - k + 1] = nums[dq.peekFirst()];
            }

        }

        return res;
    }

}
