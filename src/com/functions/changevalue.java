

package com.functions;

import java.util.Arrays;

public class changevalue {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        changename(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void changename(int[] num) {
        num[0] = 99;
    }
}


