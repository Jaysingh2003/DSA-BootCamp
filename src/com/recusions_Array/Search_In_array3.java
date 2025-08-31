package com.recusions_Array;


import java.util.ArrayList;

//search and retirn all the index of the array in the form oa an array without passing as an argument
//not agood approach but many question this concept will works
public class Search_In_array3 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 5, 2};
        int target = 2;
        ArrayList<Integer> ans = search(arr, target, 0);
        System.out.println(ans);

    }

    static ArrayList<Integer> search(int[] arr, int target, int index){
       ArrayList<Integer> list = new ArrayList<>();

       if(index == arr.length){
           return  list;
       }
       //this will contain ans for that function call only
       if(arr[index]==target){
              list.add(index);
       }
         ArrayList<Integer> ansFromBelowCalls = search(arr, target, index+1);

       list.addAll(ansFromBelowCalls);//note this line will run after all the calls are done
                                     //or we cab say when the stack is starting to pop or empty
       return list;

    }
}
