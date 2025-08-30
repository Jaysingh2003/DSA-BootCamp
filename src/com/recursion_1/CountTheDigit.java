package com.recursion_1;

class CountTheDigit {
    public static void main(String[] args) {
        CountTheDigit sol = new CountTheDigit();
        int[] nums = {12, 345, 2, 6, 7896};
        System.out.println(sol.findNumbers(nums)); // Output: 2
    }
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (hasEvenDigits(num)) {
                count++;
            }
        }
        return count;
    }

    private boolean hasEvenDigits(int num) {
        int digits = 0;
        while (num > 0) {
            num /= 10;
            digits++;
        }
        return digits % 2 == 0;
    }
    /*

//using the recursion

class CountTheDigit {
    public static void main(String[] args) {
        CountTheDigit sol = new CountTheDigit();
        int[] nums = {12, 345, 2, 6, 7896};
        System.out.println(sol.findNumbers(nums)); // Output: 2
    }

    public int findNumbers(int[] nums) {
        return findNumbersRecursive(nums, 0);
    }

    private int findNumbersRecursive(int[] nums, int idx) {
        if (idx == nums.length) return 0;
        int count = hasEvenDigits(nums[idx], 0) ? 1 : 0;
        return count + findNumbersRecursive(nums, idx + 1);
    }

    private boolean hasEvenDigits(int num, int digits) {
        if (num == 0 && digits > 0) return digits % 2 == 0;
        return hasEvenDigits(num / 10, digits + 1);
    }
}
     */
}