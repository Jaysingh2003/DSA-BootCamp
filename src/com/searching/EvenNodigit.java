package com.searching;

public class EvenNodigit {
    public static void main(String[] args) {
        int[] arr={153,294958,32,4567,457,7544};
        System.out.println(findNumbers(arr));

    }
    static  int findNumbers(int[] arr){
        int count = 0;
        for(int num : arr){
         if(even(num)){
             count++;
         }
        }
        return count;
    }
    //function to check whether a digit contain the even digit or not
    static boolean even(int num) {
        int noofdigit = digit(num);

        return noofdigit % 2==0;  //another way to write the below code
    }
//        if(noofdigit%2==0){
//            return true;
//        }
//    return false;
 // }
    static  int digit(int num){
        if(num<0){
            num = num*-1;
        }
        if(num==0){
            return 1;
        }
        int count=0;
        while (num>0){
            count++;
            num = num/10;  //In integer division (in Java), the decimal part is dropped.
		                   //This effectively removes the last digit of num.
        }
        return count;
    }
}
