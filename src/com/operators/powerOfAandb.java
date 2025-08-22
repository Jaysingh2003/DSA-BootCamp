package com.operators;

public class powerOfAandb {
    public static void main(String[] args) {
  int base=3;
  int power=6;
  int result=1;

    while (power > 0){
        if((power & 1) == 1) {//here we convert the power into the binary digit and check if the last digit is 1 or not
            result = result * base;
        }
       power = power >> 1;
        base = base * base;
      }

        System.out.println(result);

    }
    }

