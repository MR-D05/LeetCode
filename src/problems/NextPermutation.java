package problems;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int store = nums[i - 1];
                for (int j = i; j < nums.length; j++) {
                    while (nums[j] > nums[i - 1]) {
                        if (j + 1 < nums.length) {
                            if (nums[j + 1] > nums[i - 1] && nums[j + 1] <= nums[j]) {
                                j = j + 1;
                            } else {
                                nums[i - 1] = nums[j];
                                nums[j] = store;
                                sortAscending(nums, i);
                                return;
                            }
                        } else {
                            nums[i - 1] = nums[j];
                            nums[j] = store;
                            sortAscending(nums, i);
                            return;
                        }
                    }
                }
            }
        }
        sortAscending(nums, 0);
    }

    public void sortAscending(int[] nums, int left) {
        for (int i = left; i < nums.length; i++) {
            for (int j = left; j < nums.length; j++) {
                if (j + 1 < nums.length) {
                    if (nums[j] > nums[j + 1]) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        /*
        Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

        If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

        The replacement must be in-place and use only constant extra memory.

        Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

        1,2,3 → 1,3,2
        3,2,1 → 1,2,3
        1,1,5 → 1,5,1
         */

        /*
        Plan:

        1. We loop over the array starting at the final index.
        2. At any position i, we find the first occurrence of a decreasing element such that a[i-1] < a[i].
        3. We then swap a[i-1] with the next value we find to the possible values to its right that is greater than it.
        4. Finally, we sort the numbers to its right in ascending order.
         */

        /*
        Problems:

        1. This was a nightmare.
        2. We had to revise this at least 10 times, changing line 14 nums[j + 1] < nums[j] to nums[j + 1] <= nums[j] as an example.
        3. Going forward we should commit everything we try to really record our process, which is bad currently.
         */

        NextPermutation nextPermutation = new NextPermutation();
        int[] input = {4,2,4,4,3};
        nextPermutation.nextPermutation(input);
        System.out.print(Arrays.toString(input));
    }
}

/*
Answer:

 */
