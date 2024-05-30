package com.TWOPOINTER.variablesize;

/// This code implements a solution to find the maximum product of a contiguous subarray in an array of integers.
/// The algorithm maintains two variables, `maxEndingHere` and `minEndingHere`, to keep track of the maximum and minimum products ending at the current index. This is necessary because a negative number can turn a minimum product into a maximum product and vice versa. The algorithm iterates through the array, updating these variables accordingly and keeping track of the overall maximum product found.
class Max_Product_of_subarray {
    public int maxProduct(int[] arr) {
        int maxEndingHere = arr[0];
        int minEndingHere = arr[0];
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            
///             If current element is negative, swap max and min
//            beacause
//            Positive × Negative = Negative >The previous maximum may become minimum
//            Negative × Negative = Positive >The previous minimum may become maximum
            if (arr[i] < 0) {
                int temp = maxEndingHere;
                maxEndingHere = minEndingHere;
                minEndingHere = temp;
            }

            maxEndingHere = Math.max(arr[i], maxEndingHere * arr[i]);///we will either reset the max product to the current element or we will continue multiplying with the previous max product
            minEndingHere = Math.min(arr[i], minEndingHere * arr[i]);

            result = Math.max(result, maxEndingHere);
        }

        return result;
    }
}