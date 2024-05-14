package com.Greedy.Sorting_OR_Localchoice;


import java.util.Arrays;

/// https://leetcode.com/problems/maximum-units-on-a-truck/
public class Maximum_unit_truck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        int maxunits = 0;
        int trucksize = truckSize;

        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);// Sort the box types in descending order based on basisn of 2nd parameter (index 1) the number of units per box

        for (int i = 0; i < boxTypes.length; i++) {

            int box = boxTypes[i][0]; // number of boxes of this type
            int unitsPerBox = boxTypes[i][1]; // number of units per box

            if (trucksize >= box) { // If the truck can accommodate all boxes of this type
                maxunits += box * unitsPerBox; // Add all units from these boxes to the total
                trucksize -= box; // Decrease the remaining truck size by the number of boxes added
            } else { // If the truck cannot accommodate all boxes of this type
                maxunits += trucksize * unitsPerBox; // Add as many units as possible from the remaining truck size
                break; // The truck is full, so we can stop processing further box types
            }

        }
        return maxunits;


    }
}
