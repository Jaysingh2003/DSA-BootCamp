package com.TWOPOINTER.variablesize;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/// Question:- in three sum problem we have to find the triplet in the array which is equal to the target sum=0;
///  idea:- in this we fix one pointer and move other bother tqo pointer to find the triplets
///
/// fix i pointer to i=0; and then j pointer to i+1 and k pointer to n-1; and then we check the sum of arr[i]+arr[j]+arr[k]
///  if it is equal to target sum=0 then we add the triplet in the list and id sum is graterbthan zero means rsuce the sume so k should descrese
/// and if sum is less than zero then we have to increase the sum so j should increase; and we will do this until j<k;
/// (like two pointer) and then we will move i pointer to i+1 and repeat the process
/// but we also remove the duplicate triplets by checking if arr[i] is equal to arr[i-1] then we will skip the iteration
/// and move to next i; and also for j and k pointer we will check if arr[j] is equal to arr[j-1] then we will skip the iteration and move to next j; and if arr[k] is equal to arr[k+1] then we will skip the iteration and move to next k;
/// time complexity is O(n^2) and space complexity is O(n) because we are using list to store the triplets
public class ther_sum_problem {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue; /// to remove the duplicate triplets beacise if equal then the no need to caluclate the again
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) { /// we will do this for the every i pointer

                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {/// after we calculate we have remove the duplicate triplets by checking if arr[j] is equal to arr[j-1] then we will skip the iteration and move to next j; and if arr[k] is equal to arr[k+1] then we will skip the iteration and move to next k;
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1])
                        l++; /// to remove the duplicate triplets beacise if equal then the no need to caluclate the again
                    while (l < r && nums[r] == nums[r - 1])
                        r--; /// to remove the duplicate triplets beacise if equal then the no need to caluclate the again

                    l++;///after removal we have to move the pointer to next position so we get the new element
                    r--;///and also for right pointer we have to move to next position so we get the new element
                }
                if (sum > 0) {///if sum is grater than so to make its zero we have to descrease  the  sum so we will move the right pointer to left
                    l++;

                } else { /// if sum is less than zero then we have to increase the sum so we will move the left pointer to right
                    r--;
                }


            }



        }
        return res;


    }
}