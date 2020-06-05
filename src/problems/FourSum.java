package problems;

import java.util.*;

public class FourSum {
    HashSet<List<Integer>> result = new HashSet<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int third = j + 1;
                int fourth = nums.length - 1;
                while (third < fourth) {
                    int sum = nums[i] + nums[j] + nums[third] + nums[fourth];
                    if (sum < target) {
                        third++;
                    } else if (sum > target) {
                        fourth--;
                    } else {
                        List<Integer> set = new ArrayList<>();
                        set.add(nums[i]);
                        set.add(nums[j]);
                        set.add(nums[third]);
                        set.add(nums[fourth]);
                        result.add(set);
                        third++;
                        fourth--;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }


    public static void main(String[] args) {

        /*
        Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that
        a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

        Note:

        The solution set must not contain duplicate quadruplets.

        Example:

        Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

        A solution set is:
        [
          [-1,  0, 0, 1],
          [-2, -1, 1, 2],
          [-2,  0, 0, 2]
        ]
         */

        /*
        Plan:

        1. Can we do this the same way as three sum?
        2.

         */

        /*
        Problems:

        1. We tried to do this like 3 sum only with 4 pointers, and keeping the first and second in place and sliding the 3rd and 4th.
        2. Without having two for loops and the while loop going on inside the inner for loop, we would not consider all the necessary
           indices.
        3. We need to have fixed positions with the 2 for loops and then slide the window for 2 other positions with the while loop in order
           to cover all territory.
         */

        FourSum fourSum = new FourSum();
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        //[-3,-2,-1,0,0,1,2,3]
        //0
        System.out.print(fourSum.fourSum(nums, 0));
    }
}

/*
Answer:

    public static List<List<Integer>> fourSum(Integer[] nums, int target) {

        Arrays.sort(nums);

        HashSet<List<Integer>> returnList = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                HashSet<Integer> hashSet = new HashSet<>();
                for (int k = j + 1; k < nums.length; k++) {
                    if (hashSet.contains(target - (nums[i] + nums[j] + nums[k]))) {
                        List<Integer> integerList = new ArrayList<>();
                        integerList.add(nums[i]);
                        integerList.add(nums[j]);
                        integerList.add(target - (nums[i] + nums[j] + nums[k]));
                        integerList.add(nums[k]);
                        returnList.add(integerList);
                    }
                    hashSet.add(nums[k]);
                }
            }
        }
        return new ArrayList<>(returnList);
    }
 */
