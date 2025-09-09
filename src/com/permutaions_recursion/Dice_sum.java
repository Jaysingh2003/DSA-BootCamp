package com.permutaions_recursion;

import java.util.ArrayList;
import java.util.List;

public class Dice_sum {
    public static void main(String[] args) {
        dice_sum("", 4);
        System.out.println(diceList("", 4));
        diceFace_change("", 5, 9);//we can get test upto1 18 ->

    }
    static void dice_sum(String p, int target){
        if(target == 0){
            System.out.println(p);
            return;
        }
        for(int i = 1; i <= 6 && i <= target; i++){
            dice_sum(p + i, target - i);
        }

    }

    //retiurn in arraylist
    static ArrayList<String> diceList(String p, int target){
        if(target == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 1; i <= 6 && i <= target; i++){
            ans.addAll(diceList(p + i, target - i));
        }
        return ans;
    }

    //if dice face is chnaged
    static void diceFace_change(String p, int target, int face){
        if(target == 0){
            System.out.println(p);
            return;
        }
        for(int i = 1; i <= face && i <= target; i++){
            dice_sum(p + i, target - i);
        }

    }

    //retiurn in arraylist
    static ArrayList<String> iceFace_change_list(String p, int target,int face){
        if(target == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 1; i <= face && i <= target; i++){
            ans.addAll(iceFace_change_list(p + i, target - i, face));
        }
        return ans;
    }
}
