package com.searching;

public class Maxin2d {
    public static void main(String[] args) {
        int[][] arr = {
                {5, 6, 7},
                {8, 9, 20, 55, 56},
                {4, 6, 4, 3, 76, 44, 67}
        };
        System.out.println(max(arr));
    }
      static int max(int[][] arr){
          int maxvalue =arr[0][0];//int maxvalue=Integer.MIN.VAlUE
          for(int[] ints : arr){
              for(int element:ints){
                  if(element>maxvalue){
                      maxvalue=element;
                  }
              }
          }
          return maxvalue;
        }
    }

