package problems;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int total = nums[0];
        int returnValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            returnValue = Math.max(returnValue, total);
            total += nums[i];
            if (total > nums[i]) continue;
            total = 0;
            total += nums[i];
        }
        return Math.max(returnValue, total);
    }

    public static void main(String[] args) {

        /*
        Given an integer array nums, find the contiguous subarray (containing at least one number)
        which has the largest sum and return its sum.

        Example:

        Input: [-2,1,-3,4,-1,2,1,-5,4],
        Output: 6
        Explanation: [4,-1,2,1] has the largest sum = 6.

        Follow up:

        If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
        which is more subtle.
         */

        /*
        Plan:

        1. You have an int total variable = first index value, and a return variable.
        2. Looping over the array starting at 1, you add the index i to the total.
        3. If total is > than index i continue, else returnValue = Math.max(total, returnValue), total = 0, total += index i.
         */

        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maximumSubarray.maxSubArray(nums));
    }
}

/*
Answer:

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int total = nums[0];
        int returnValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            returnValue = Math.max(returnValue, total);
            total += nums[i];
            if (total > nums[i]) continue;
            total = 0;
            total += nums[i];
        }
        return Math.max(returnValue, total);
    }
 */
