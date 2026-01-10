package com.stringandstringbuilder;

public class RomanNumber {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(symbols[i]);
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        RomanNumber romanNumber = new RomanNumber();
        int number = 1994;
        String romanNumeral = romanNumber.intToRoman(number);
        System.out.println("The Roman numeral for " + number + " is: " + romanNumeral);
    }
}
