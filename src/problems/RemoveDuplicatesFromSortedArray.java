package problems;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {

        /*
        Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
        Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

        Example 1:

            Given nums = [1,1,2],

        Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

        It doesn't matter what you leave beyond the returned length.

        Example 2:

        Given nums = [0,0,1,1,1,2,2,3,3,4],

        Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

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

        1. Since we have a sorted array, maybe we can, setup a length in variable, and we have a value int variable, and
           we loop over the array and say, if position i's value is the same as value, continue, else, we increment length.
        2. Return length.
        3. Looking at it now, looks like we need to start from the right side as it will print length number of elements.
        4. So we have another temp int value, and we say, value is equal to last element, then were at position --, and we say,
           if the value at that position is the same, continue, else we set temp equal to that value, we update nums[i] to our
           value value, then we update value to temp.
         */

        /*
        Problems:

        1. Our plan was utterly wrong.
        2. The answer is 2 pointers.
        3. Our i int variable stays put and increments when our looping j int variable gets to a point where nums[j] does
           not equal nums[i].
        4. At this point we increment i in the array and copy the value of nums[j] to it.
        5. Since we are dealing with arrays, we return the value of i + 1;
         */

        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        //[0,0,1,1,1,2,2,3,3,4]
        //int[] nums = {1, 1, 2};
        //int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(nums));
    }
}

/*
Answer:
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
 */
