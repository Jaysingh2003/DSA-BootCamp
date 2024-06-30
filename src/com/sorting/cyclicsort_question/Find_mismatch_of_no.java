package com.sorting.cyclicsort_question;

//Find Missing + Duplicate Together
//Find the mismatch of number in an array means we have to find the missing number and the repating number in an array of n numbers where the numbers are from 1 to n
public class Find_mismatch_of_no {

    public static int[] findmismatch(int[] arr){

        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;
            if(arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }else{
                i++;
            }
        }


        //after sorting the array in question   we have to  find one number is missing and one number is repating so that the
        //missing number is the index+1 and the repating number is the value at that index
        //
        for(int j=0;j<arr.length;j++){
            if(arr[j]!=j+1){//if the value at index j is not equal to j+1 then we have found the mismatch of number
                return new int[]{arr[j],j+1};
            }
        }
        return new int[]{-1,-1};
    }
     static  void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
