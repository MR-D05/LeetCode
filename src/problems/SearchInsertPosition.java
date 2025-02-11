package problems;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {

        /*
        Given a sorted array and a target value, return the index if the target is found. If not, return the index where
        it would be if it were inserted in order.

        You may assume no duplicates in the array.

        Example 1:

        Input: [1,3,5,6], 5
        Output: 2

        Example 2:

        Input: [1,3,5,6], 2
        Output: 1

        Example 3:

        Input: [1,3,5,6], 7
        Output: 4

        Example 4:

        Input: [1,3,5,6], 0
        Output: 0
         */

        /*
        Plan:

        1. Loop over array with two conditions: if nums[i] >= target, return i, else, return i+1.
         */

        /*
        Problems:

        1. Needed to return nums.length, not nums.length+1, as it would be the next position in the array.
         */

        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsertPosition.searchInsert(nums, 0));
    }
}

/*
Answer:

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
 */
