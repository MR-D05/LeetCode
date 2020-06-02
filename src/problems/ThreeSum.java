package problems;

import java.util.*;

public class ThreeSum {
    HashSet<List<Integer>> result = new HashSet<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            threeSum(i, nums);
        }
        return new ArrayList<>(result);
    }

    public void threeSum(int first, int[] nums) {
        List<Integer> set = new ArrayList<>();
        int second = first + 1;
        int third = nums.length - 1;
        while (second < third) {
            int sum = nums[first] + nums[second] + nums[third];
            if (sum < 0) {
                second++;
            }
            else if (sum > 0) {
                third--;
            }
            else {
                set.add(nums[first]);
                set.add(nums[second]);
                set.add(nums[third]);
                result.add(set);
                second++;
                third--;
                set = new ArrayList<>();
            }
        }
    }

    public static void main(String[] args) {

        /*
        Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
        Find all unique triplets in the array which gives the sum of zero.

        Note:

        The solution set must not contain duplicate triplets.

        Example:

        Given array nums = [-1, 0, 1, 2, -1, -4],

        A solution set is:
        [
          [-1, 0, 1],
          [-1, -1, 2]
        ]
         */

        /*
        Plan:

        1. Our solution starts by sorting the array.
        2. Now at a high level, we have a first, second, and third variables that represent the numbers being added.
        3. We have a for loop in the main function over the length of nums.
        4. Each iteration will drop into another function that uses the left and right variables.
        5. That function has a while loop that has nums[i] as the first number and starts with i+1 as the second number,
           and nums.length-1 as the third number.
        6. The while loops condition is while second < third, we test out three conditions.
        7. First is, if the sum of those numbers is greater than 0, we decrement the third number pointer.
        8. If the sum is less than 0, we increment the second number pointer.
        9. If the sum is 0, we have a contender, we attempt to add it to our result.
        10. Our result variable is a hashset of list of integers, so we attempt to add the three numbers and if it's already
            present, it won't add a duplicate.
         */

        /*
        Problems:

        1. If function finds a correct solution, it returns, and first position is updated and never considered again,
           even if there were more possibilities the way we did it initially. We instead needed to do second++ third-- in the else block.
        2. We tried setting set to a new array list in the else block. Actually this is fine.
        3. We, for some crazy reason, did second++ third-- before adding them to the set and adding that to the result,
           which completely screwed up the positioning.
        4. We declared List<Integer> set = new ArrayList<>(); outside of the while loop initially.
         */


        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-2, 0, 1, 1, 2};
        System.out.print(threeSum.threeSum(nums));
    }
}

/*
Answer:

    public static List<List<Integer>> threeSum(Integer[] nums) {

       // Arrays.sort(nums);

        System.out.print(Arrays.toString(nums));

        HashSet<List<Integer>> returnList = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (hashSet.contains(-nums[i] - nums[j])) {
                    List<Integer> integerList = new ArrayList<>();
                    integerList.add(nums[i]);
                    integerList.add(-nums[i] - nums[j]);
                    integerList.add(nums[j]);
                    returnList.add(integerList);
                }
                hashSet.add(nums[j]);
            }
        }
        return new ArrayList<>(returnList);
    }

 */
