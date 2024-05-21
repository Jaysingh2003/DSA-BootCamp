package com.Rising_Brain_Array_Pattern.Sliding_Window;
import java.util.HashMap;
//For the Maximum Toys / Fruits into Baskets problem (longest substring with at most k distinct characters),
// the correct code is:
///https://leetcode.com/problems/fruit-into-baskets/description/
public class maxToys_MaxFruits {

    /// Broute Force appraoch
    public class MaxToys {
        public int maxToys(String str, int k) {
            int n = str.length();
            int ans = 0;

            for (int i = 0; i < n; i++) {
                HashMap<Character, Integer> map = new HashMap<>();
                for (int j = i; j < n; j++) {
                    char ch = str.charAt(j);
                    map.put(ch, map.getOrDefault(ch, 0) + 1);
                    if (map.size() <= k) {
                        int length = j - i + 1;
                        ans = Math.max(ans, length);
                    } else {
                        break;
                    }
                }
            }
            return ans;
        }
    }

    /// optimxed approch

    public int maxToysII(String str, int k) {
        int left = 0;
        int ans = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < str.length(); right++) {

            char ch = str.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() > k) {
                char leftChar = str.charAt(left);
                map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        maxToys_MaxFruits obj = new maxToys_MaxFruits();
        int ans = obj.maxToysII("abcccab", 2);
        System.out.println(ans);
    }
}