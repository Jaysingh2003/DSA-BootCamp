package com.SerchingQuestions;

public class PeakIndexMountain {
    public static void main(String[] args) {
    int[] arr = {1, 2, 4, 5, 4, 3, 2};
        int ans = peakIndexInMountainArray(arr);
        System.out.println(ans);

    }
     static int peakIndexInMountainArray( int[] arr){


        int start =0;
        int end = arr.length-1;

        while (start < end){
          int mid = start + (end-start)/2;

           if(arr[mid] > arr[mid+1]){
               end = mid;//the array is in ascending order acc to this condition
           }else {
               start = mid+1;//arr[mid+1] element is greater than arr[mid];
           }

        }
        //In the end  , start == end and pointing to the largest element because of the two checks
        //start and the end always pointing to the same object  end the last hence they are pinting to the last element
     return start ;//or return end  ->because the both are equal at the end
     }
}
