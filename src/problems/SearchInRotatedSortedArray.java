package problems;

public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {

        int left;
        int right;
        int returnValue;

        if (nums.length % 2 == 0) {
            left = nums.length / 2 - 1;
        } else {
            left = nums.length / 2;
        }
        right = nums.length / 2;
        returnValue = expandFromCenter(nums, target, left, right);

        return returnValue;

    }

    public static int expandFromCenter(int[] nums, int target, int left, int right) {
        while (left >= 0 && right <= nums.length) {
            if (nums[left] == target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            }
            left--;
            right++;
        }
        return -1;
    }


    public static void main(String[] args) {
        /*
        Example 1:

        Input: nums = [4,5,6,7,0,1,2], target = 0
        Output: 4
        Example 2:

        Input: nums = [4,5,6,7,0,1,2], target = 3
        Output: -1
         */

        int[] nums = {4,5,6,7,0,1,2};

        System.out.println(search(nums, 3));
    }
}
