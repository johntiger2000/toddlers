package jun.practice.quickselect;

import jun.practice.Main;

public class Solution {
	public static void main(String[] args) {
		//int ret = new Solution().findKthLargest({-1,2,0}, 2);
		//System.out.println(ret);
	}

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int pivotIndex = partition(nums, i, j);
            if (pivotIndex == k-1) {
                return nums[k-1];
            } else if (pivotIndex > k-1) {
                j = pivotIndex - 1;
            } else {
                i = pivotIndex + 1;
            }
        }
        return nums[i-1];
    }
    
    int partition(int[] nums, int i, int j) {
        int pivot = nums[(i+j)/2];
        while (i <= j) {
            if (pivot > nums[j]) {
                --j;
            } else if (pivot <= nums[i]) {
                ++i;
            } else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                ++i;
                --j;
            }
        }
        return i-1;
    }
}
