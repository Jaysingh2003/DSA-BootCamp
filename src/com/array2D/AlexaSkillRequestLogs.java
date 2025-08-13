package com.array2D;

import java.util.*;

public class AlexaSkillRequestLogs {
    public static void main(String[] args) {
        int numSkills = 3;
        int timeWindow = 5;
        int[][] requestLogs = {{1, 3}, {2, 6}, {1, 5}};
        int[] queryTimes = {10, 11};
        int[] result = findSkillsWithoutRequests(numSkills, timeWindow, requestLogs, queryTimes);
        System.out.println(Arrays.toString(result));  // Expected output: [1, 2]
    }

    public static int[] findSkillsWithoutRequests(int numSkills, int timeWindow, int[][] requestLogs, int[] queryTimes) {
        int[] results = new int[queryTimes.length];
        for (int i = 0; i < queryTimes.length; i++) {
            int queryTime = queryTimes[i];
            int startTime = queryTime - timeWindow;
            Set<Integer> activeSkills = new HashSet<>();
            for (int[] log : requestLogs) {
                int skillID = log[0];
                int timeStamp = log[1];
                if (timeStamp >= startTime && timeStamp <= queryTime) {
                    activeSkills.add(skillID);
                }
            }
            results[i] = numSkills - activeSkills.size();
        }
        return results;
    }
}