package com.dynamicprograming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/frog-jump/
public class FrogJump_1 {

    public boolean canCross(int[] stones) {
        int n = stones.length;

        // First jump must be 1, so if second stone is not at 1 means ki  leth of stone will we one unit so that it can jump, impossible
        if (n > 1 && stones[1] != 1) return false;

        // Map: stone position -> set of jump sizes that can reach this stone
        Map<Integer, Set<Integer>> map = new HashMap<>();

        // each stone position has an empty set ready to hold jump sizes.
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }

        // Starting at position 0 with last jump = 0
        map.get(0).add(0);

        int lastStone = stones[n - 1];

        for (int pos : stones) {//for every postion ke liye we have store the possible jumps in the set named jumps
            Set<Integer> jumps = map.get(pos);//get the possible jumps to reach this position

            for (int k : jumps) {
                // try k-1, k, k+1
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step <= 0) continue; // must move forward

                    int nextPos = pos + step;

                    if (nextPos == lastStone) {
                        return true; // can reach last stone
                    }

                    if (map.containsKey(nextPos)) {
                        map.get(nextPos).add(step);
                    }
                }
            }
        }

        return false;
    }
}
