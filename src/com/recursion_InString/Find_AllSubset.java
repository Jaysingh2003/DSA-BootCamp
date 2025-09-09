package com.recursion_InString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// https://leetcode.com/problems/subsets/description/
public class Find_AllSubset {
    public static void main(String[] args) {
        int[] num = {1,2,3};
//        System.out.println(findSubsets(num));
        List<List<Integer>> list = findSubsets(num);
        for (List<Integer> l : list) {
            System.out.println(l);
        }


    }
    static List<List<Integer>> findSubsets(int[] num){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());//add empty array list to the outer list
        for(int n : num){//for every number in the input array
            //outer list ki size means if the outer list has 4 array list then we have to copy all the 4 array list
            int size = outer.size();//every new array list will be the size of the outer list
            for(int i=0; i<size; i++){//outer list ki size tak hi loop chalega
                List<Integer> internal = new ArrayList<>(outer.get(i));//get the ith element of the outer list
                internal.add(n);//add the current number to the internal list
                outer.add(internal);//copy the internal list to the outer list
            }
        }
        return outer;

    }

    // Time Complexity: O(N * 2^N)
    // Space Complexity: O(N * 2^N)

    //if the duplicate elment is poresent

    static List<List<Integer>> findSubsetsDuplicate(int[] nums){
        List<List<Integer>> outer = new ArrayList<>();
        Arrays.sort(nums);
       outer.add(new ArrayList<>());
       int start = 0;
       int end = 0;
       for(int i=0; i<nums.length; i++){
             start = 0;
              //if current and previous element are same, new subsets are only formed from the subsets
                //added in the previous step
           if(i>0  && nums[i] == nums[i-1]){
                start = end + 1;
              }
              end = outer.size() - 1;
           }
              int size = outer.size();
                for(int j=start; j<size; j++){
                    List<Integer> internal = new ArrayList<>(outer.get(j));
                    internal.add(nums[j]);
                    outer.add(internal);
       }
        return outer;


    }

}
