package com.algo.array;

public class MinSubArrayLength {
	
	public int minSubArrayLenImprove(int s, int[] nums) {
	    if (null == nums || nums.length == 0) {
	        return 0;
	    }
	    int left = 0;
	    int right = 0;
	    int min = nums.length + 1;
	    int sum = 0;
	    while (right < nums.length) {
	        sum += nums[right];
	        while (sum >= s) {
	            min = Math.min(min, right - left + 1);
	            sum -= nums[left];
	            left++;
	        }
	        right++;
	    }
	    return min == nums.length + 1 ? 0 : min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
