package com.recursion_InString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset_duplicate_elemnt {
    public static void main(String[] args) {
        int[] num = {1,2,2};
        List<List<Integer>> list = findSubsets(num);
        for (List<Integer> l : list) {
            System.out.println(l);
        }

    }
    static List<List<Integer>> findSubsets(int[] num){
        List<List<Integer>> outer = new ArrayList<>();
        Arrays.sort(num);//sort so that duplicate elements are adjacent
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for(int i=0; i<num.length; i++){
            start = 0;//for every new element, start from 0, we must extend all subsets in outer.
            //if current and previous element are same, new subsets are only formed from the subsets
            //added in the previous step
            if(i>0 && num[i] == num[i-1]){
                start = end + 1;
            }
            end = outer.size() - 1;
            int size = outer.size();
            for(int j=start; j<size; j++){//start from 0 if current and previous element are not same for the coppying
                //of all the subsets in outer
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(num[i]);
                outer.add(internal);
            }
        }


        return outer;
    }
}
