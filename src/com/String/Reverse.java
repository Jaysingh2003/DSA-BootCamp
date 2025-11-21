package com.String;

public class Reverse {
    // O(n^2) time complexity and O(n) space complexity inefficient method
    static  void  reverseString(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        System.out.println("Reversed String: " + reversed);
    }
        //another method

        // O(n) and 0(1)space complixty using StringBuilder
        static String reverseString1 (String str){
            if (str == null) return null;
            return new StringBuilder(str).reverse().toString();
        }

        // Driver code
    static String reverseString2 (String str){
        char[] charArray = str.toCharArray();
        int left = 0, right = charArray.length - 1;
        while (left < right) {
            // Swap characters
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);// Convert char array back to string
    }



    public static void main(String[] args) {
        String str = "Hello, World!";
        reverseString(str);
        String reversedStr = reverseString1(str);
        System.out.println("Reversed String using StringBuilder: " + reversedStr);
        String reversedStr2 = reverseString2(str);
        System.out.println("Reversed String using two-pointer technique: " + reversedStr2);

    }
}
