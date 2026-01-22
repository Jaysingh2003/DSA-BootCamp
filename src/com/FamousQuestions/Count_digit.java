package com.FamousQuestions;

public class Count_digit {
    public class count_digit {
        public static int countdigit(String str) {
            int count = 0;

            for (char ch : str.toCharArray()) {
                if (Character.isDigit(ch)) {
                    count++;
                }
            }
            return count;
        }

    }

    public static void main(String[] args) {
        String str = "abc123def456ghi789";
        int digitCount = count_digit.countdigit(str);
        System.out.println("Number of digits in the string: " + digitCount);
    }
}
