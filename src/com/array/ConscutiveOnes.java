package com.array;

public class ConscutiveOnes {
    public static void main(String[] args) {
        int[] arr={1,1,1,1,1,1,0,0,1,1,1,1,1};
        int num=Conscutive(arr);
        System.out.println(num);

    }
    static int Conscutive(int[] arr){
        int maxCount = 0;
        int currentCount = 0;
        for(int num: arr){
            if(num == 1){
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            }else {
                currentCount = 0;
            }
        }
        return maxCount;
    }
}
