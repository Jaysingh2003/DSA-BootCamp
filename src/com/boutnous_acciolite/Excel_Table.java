package com.boutnous_acciolite;

///  Convert a number to Excel Column Name
public class Excel_Table {
    public static String convert(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;/// Adjust for 0-indexing beacause Excel columns are 1-indexed and in programing we use 0-indexing->a-z(0-25
            sb.append((char) ('A' + n % 26));///% 26 → gives the current digit
            n /= 26;///= 26 → removes the processed digit and moves left
        }
        return sb.reverse().toString();// Reverse the string to get the correct order
    }
}
//