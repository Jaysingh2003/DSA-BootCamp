package com.Reverse_All_type_problem;

//complexity is O(n) and space complexity is O(n)
public class Reverse_Only_Vowels {
    public static boolean isvowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            return true;
        else {
            return false;
        }

    }
    public static String swapVowels(String str) {
        char[] arr = str.toCharArray();// Convert the string to a character array for in-place modification
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (!isvowel(arr[left])) {
                left++;
            } else if (!isvowel(arr[right])) {
                right--;
            } else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }

        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String str = "hello world";
        String result = swapVowels(str);
        System.out.println(result);

    }

}
