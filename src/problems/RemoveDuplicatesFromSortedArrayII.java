package problems;

public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int current;
        int previous = nums[nums.length - 1];
        int index = 0;
        int counter = 0;

        for (int i = 0; i < nums.length; i++) {
            current = nums[i];

            if (previous == current && counter == 2) {
                continue;
            }

            nums[index] = nums[i];
            index++;

            if (previous != current) {
                previous = current;
                counter = 1;
            } else {
                counter++;
            }
        }

        return index;
    }


    public static void main(String[] args) {

        /*
        Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

        Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

        Example 1:

        Given nums = [1,1,1,2,2,3],

        Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

        It doesn't matter what you leave beyond the returned length.

        Example 2:

        Given nums = [0,0,1,1,1,1,2,3,3],

        Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

        It doesn't matter what values are set beyond the returned length.

        Clarification:

        Confused why the returned value is an integer but your answer is an array?

        Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

        Internally you can think of this:

        // nums is passed in by reference. (i.e., without making a copy)
        int len = removeDuplicates(nums);

        // any modification to nums in your function would be known by the caller.
        // using the length returned by your function, it prints the first len elements.
        for (int i = 0; i < len; i++) {
            print(nums[i]);
        }
         */

        /*
        Plan:

        1. We will use a counter.
        2. We have a previous int variable representing the previous value considered in the loop.
        3. We have a current int variable that represents the current value under consideration.
        4. We also have an index int variable that represents the index we are copying to.
        5. The idea is to increment the counter if we see a consecutive occurrence of current.
        6. If the counter is thus at 2, we skip that iteration of the loop.
        7. So, if previous == current && counter == 2, skip it.
        8. Barring that, we set nums[index] = nums[i] and increment the index.
        9. Now, we say if prev does not equal current, we set prev equal to current, put the counter back to 1, else
           we increment the counter.
         */

        RemoveDuplicatesFromSortedArrayII removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArrayII();
        //int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        //int[] nums = {1,1,1,1,2,2, 2,3};
        //int[] nums = {1,1,1,1};
        //int[] nums = {0,0,0,0,0};
        int[] nums = {0, 1, 2, 2, 2, 2, 2, 3, 4, 4, 4};
        //int[] nums = {0, 0, 1, 1, 1, 1, 2, 2, 2};


        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(nums));

    }
}

/*
Answer:

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int current;
        int previous = nums[nums.length-1];
        int index = 0;
        int counter = 0;

        for (int i = 0; i<nums.length; i++) {
            current = nums[i];

            if (previous == current && counter == 2) {
                continue;
            }

            nums[index] = nums[i];
            index++;

            if (previous != current) {
                previous = current;
                counter = 1;
            } else {
                counter++;
            }
        }

        return index;
    }
 */
