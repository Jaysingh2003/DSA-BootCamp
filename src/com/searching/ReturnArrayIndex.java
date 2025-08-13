package com.searching;

import java.util.HashMap;

public class ReturnArrayIndex {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,7};
        int target =9;
        int[] newarr=Returnarray(arr,target);
        System.out.println("Indexes: " + newarr[0] + ", " + newarr[1]);
    }
    static int[] Returnarray(int[] arr,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i< arr.length;i++){
            int num = target-arr[i];

            if(map.containsKey(num)){
                return  new int[]{map.get(num),i};
            }
            map.put(arr[i],i);
        }
        return new int[]{};
    }
}
