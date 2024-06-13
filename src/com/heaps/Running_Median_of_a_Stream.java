package com.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Running_Median_of_a_Stream {
    /// broyte firece (Maintain a list data > Add it to data >sort the data after each insertion > Find the median from the sorted list data)
    /// O(N² log N)
    public class RunningMedianBrute {

        List<Integer> data = new ArrayList<>();

        public void addNum(int num) {
            data.add(num);
            Collections.sort(data); // brute force step
        }

        public double findMedian() {
            int n = data.size();
            if (n % 2 == 1) {
                return data.get(n / 2);
            }
            return (data.get(n / 2 - 1) + data.get(n / 2)) / 2.0;
        }
    }


    /// optimal approach (Maintain two heaps > Add the data to the appropriate heap > Balance the heaps > Find the median from the top of the heaps)
//  1.	Insert number into Max Heap
//	2.	Move top of Max Heap → Min Heap
//	3.	Balance sizes if difference > 1
//  4.	Compute median

    public class RunningMedian {

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder()); // left
        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>(); // right

        public void addNum(int num) {

            // Step 1: add to max heap
            maxHeap.offer(num);

            // Step 2: move largest of left to right
            minHeap.offer(maxHeap.poll());

            // Step 3: balance heaps
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
            return maxHeap.peek();// max heap will always have one more element than min heap
        }
    }
}
