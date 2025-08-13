package com.patternQuestion;

public class Pattern30 {
    public static void main(String[] args) {
 pattern30(5);
    }

    static void pattern30(int n) {
        for (int row = 1; row < n; row++) {
            // Print spaces
            //ye bad me sochna ki sapces kitne hoge  after apply the logic
            for (int space = 1; space <= n - row; space++) {
                System.out.print("  ");
            }
            for (int col = row; col >= 1; col--) {//row se 1  tak chalega loop after that it will start incresing from the 2
                System.out.print(col+" ");
            }
            for (int col = 2; col <= row; col++) {//
                System.out.print(col+" ");
            }


            System.out.println();
        }


    }
}

    /*
    output:
       1
     2 1 2
   3 2 1 2 3
 4 3 2 1 2 3 4

     */