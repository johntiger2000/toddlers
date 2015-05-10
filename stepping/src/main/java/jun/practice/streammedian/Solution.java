package jun.practice.streammedian;

import java.util.PriorityQueue;

public class Solution {
	
	public static void main(String[] args) {
		int[] L = {2147483644,2147483645,2147483646,2147483647};
		//int[] num = {41,23,87,55,50,53,18,9,39,63,35,33,54,25,26,49,74,61,32,81,97,99,38,96,22,95,35,57,80,80,16,22,17,13,89,11,75,98,57,81,69,8,10,85,13,49,66,94,80,25,13,85,55,12,87,50,28,96,80,43,10,24,88,52,16,92,61,28,26,78,28,28,16,1,56,31,47,85,27,30,85,2,30,51,84,50,3,14,97,9,91,90,63,90,92,89,76,76,67,55};
		int[] num = {1,2,3,4,5};
		new Solution().medianII(num);
	}
	
    public int[] medianII(int[] nums) {
        // write your code here
        int[] result = new int[nums.length];
        if (nums.length == 0) {
            return result;
        }
        
        int median = nums[0];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        result[0] = median;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < median) {
                maxHeap.add(-nums[i]);
            } else {
                minHeap.add(nums[i]);
            }
            
            if (maxHeap.size() > minHeap.size()) {
                minHeap.add(median);
                median = -maxHeap.poll();
            } else if (maxHeap.size() + 1 < minHeap.size()) {
                maxHeap.add(-median);
                median = minHeap.poll();
            }
            
            result[i] = median;
        }
        
        return result;
    }
}
