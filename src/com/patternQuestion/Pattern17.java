package com.patternQuestion;

public class Pattern17 {
    public static void main(String[] args) {
        pattern31(5);
    }
    static void pattern31(int n) {
        for (int row = 1; row < 2 * n; row++) {
            int totalcols = row > n ? 2 * n- row : row;
            // Print spaces
            //ye bad me sochna ki sapces kitne hoge  after apply the logic
            for (int space = 1; space <= n - totalcols; space++) {
                System.out.print("  ");
            }
            for (int col = totalcols; col >= 1; col--) {//row se 1  tak chalega loop after that it will start incresing from the 2
                System.out.print(col+" ");
            }
            for (int col = 2; col <= totalcols; col++) {//
                System.out.print(col+" ");
            }


            System.out.println();
        }
}
    }

    /*
     1
      2 1 2
    3 2 1 2 3
  4 3 2 1 2 3 4
5 4 3 2 1 2 3 4 5
  4 3 2 1 2 3 4
    3 2 1 2 3
      2 1 2
        1

     */