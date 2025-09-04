package com.recursion_InString;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/subsets/description/
public class Find_AllSubset {
    public static void main(String[] args) {
        int[] num = {1,2,3};
        System.out.println(findSubsets(num));

    }
    static List<List<Integer>> findSubsets(int[] num){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());//add empty array list to the outer list
        for(int n : num){//for every number in the input array
            int size = outer.size();//every new array list will be the size of the outer list
            for(int i=0; i<size; i++){//outer list ki size tak hi loop chalega
                List<Integer> internal = new ArrayList<>(outer.get(i));//get the ith element of the outer list
                internal.add(n);//add the current number to the internal list
                outer.add(internal);//copy the internal list to the outer list
            }
        }
        return outer;

    }
}
