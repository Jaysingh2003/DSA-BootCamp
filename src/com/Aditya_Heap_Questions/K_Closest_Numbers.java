package com.Aditya_Heap_Questions;

import java.util.PriorityQueue;

class Pair {
    int diff;
    int number;

    Pair(int diff,int number){
        this.diff = diff;
        this.number = number;
    }
}
public class K_Closest_Numbers {

    public static int[]  kClosest(int[] nums, int k, int x){

        int[] result = new int[k];
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b) -> b.diff - a.diff);///max heap and comp[are on the ebassis of diff

        for (int num : nums) {
            int diff = Math.abs(x - num);
            if (maxHeap.size() < k) {
                maxHeap.add(new Pair(diff, num));
            } else {///k elemeent se jayda or equal hone par
                if (diff < maxHeap.peek().diff) {
                    maxHeap.poll();
                    maxHeap.add(new Pair(diff, num));
                }
            }
        }

        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll().number;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {10, 2, 14, 4, 7, 6};
        int k = 2;
        int x = 5;
        int[] ans = kClosest(nums,k,x);
        for (int i = 0; i <ans.length ; i++) {
            System.out.print(ans[i] + " ");
        }
    }


}
