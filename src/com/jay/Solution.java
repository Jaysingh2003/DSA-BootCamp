package com.jay;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // Read numSkills
        int numSkills = Integer.parseInt(reader.readLine().trim());
        
        // Read m (number of request logs)
        int m = Integer.parseInt(reader.readLine().trim());
        int[][] requestLogs = new int[m][2];
        
        // Read requestLogs
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine().trim());
            requestLogs[i][0] = Integer.parseInt(st.nextToken());
            requestLogs[i][1] = Integer.parseInt(st.nextToken());
        }
        
        // Read q (number of queries)
        int q = Integer.parseInt(reader.readLine().trim());
        int[] queryTimes = new int[q];
        
        // Read queryTimes
        for (int i = 0; i < q; i++) {
            queryTimes[i] = Integer.parseInt(reader.readLine().trim());
        }
        
        // Read timeWindow
        int timeWindow = Integer.parseInt(reader.readLine().trim());
        
        // Process each query
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int queryTime = queryTimes[i];
            int startTime = queryTime - timeWindow;
            Set<Integer> activeSkills = new HashSet<>();
            
            // Check which skills received requests in the given time window
            for (int[] log : requestLogs) {
                int skillID = log[0];
                int timeStamp = log[1];
                if (timeStamp >= startTime && timeStamp <= queryTime) {
                    activeSkills.add(skillID);
                }
            }
            
            // Calculate the number of skills without requests in the time window
            int inactiveSkills = numSkills - activeSkills.size();
            output.append(inactiveSkills).append("\n");
        }
        
        // Print the result
        System.out.print(output.toString());
    }
}