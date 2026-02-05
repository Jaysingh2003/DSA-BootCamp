package com.boutnous_acciolite;


/// https://leetcode.com/problems/zigzag-conversion/description/
///
/// in a zigzag pattern on a given number of rows, read line by line.
/// 1. create an array of string builders for each row
/// 2. iterate through the string and append each character to the appropriate row
/// 3. use a boolean flag to determine whether we are going down or up the rows
/// 4. finally, concatenate all the rows to get the final result
public class ZigZag_String {
    public static String ZigZag(String s, int numRows){
        if(numRows==1 || s.length()<=numRows){
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            rows[i]=new StringBuilder();
        }
        int currentRow=0;
        boolean goingDown=false;
        for(char c:s.toCharArray()){
            rows[currentRow].append(c);
            if(currentRow==0 || currentRow==numRows-1){
                goingDown=!goingDown;
            }
            currentRow+=goingDown?1:-1;
        }
        StringBuilder result=new StringBuilder();
        for(StringBuilder row:rows){
            result.append(row);
        }
        return result.toString();
    }

}
