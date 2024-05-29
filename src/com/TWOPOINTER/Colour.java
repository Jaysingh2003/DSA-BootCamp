package com.TWOPOINTER;

public class Colour {
    public void sortcolour(int[] arr){

        int low=0;
        int mid=0;
        int hoight=arr.length-1;

        while(mid<=hoight){
            if(arr[mid]==0){
                swap(arr,low,mid);
                low++;
                mid++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else{
                swap(arr,mid,hoight);
                hoight--;
            }
        }

    }
    public static void swap(int[] arr,int low,int mid){
        int temp=arr[low];
        arr[low]=arr[mid];
        arr[mid]=temp;
    }

}
