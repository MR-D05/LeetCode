package problems;

public class RemoveElement {

    //{0,1,2,2,3,0,4,2};

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {

        /*
        Given an array nums and a value val, remove all instances of that value in-place and return the new length.

        Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

        The order of elements can be changed. It doesn't matter what you leave beyond the new length.

        Example 1:

        Given nums = [3,2,2,3], val = 3,

        Your function should return length = 2, with the first two elements of nums being 2.

        It doesn't matter what you leave beyond the returned length.

        Example 2:

        Given nums = [0,1,2,2,3,0,4,2], val = 2,

        Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

        Note that the order of those five elements can be arbitrary.

        It doesn't matter what values are set beyond the returned length.

        Clarification:

        Confused why the returned value is an integer but your answer is an array?

        Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

        Internally you can think of this:

        // nums is passed in by reference. (i.e., without making a copy)
        int len = removeElement(nums, val);

        // any modification to nums in your function would be known by the caller.
        // using the length returned by your function, it prints the first len elements.
        for (int i = 0; i < len; i++) {
            print(nums[i]);
        }
         */

        /*
        Plan:

        1. This one is kind of similar to remove duplicates from sorted array in that we have two pointers.
        2. The differences is that j will start at position 0 not 1, since we have to consider the first element and
           whether it is equal to val.
        3. Our condition inside the for loop is if nums[j] is not equal to val, we set nums[i] equal to nums[j], and
           THEN we increment i.
        4. We return just i and not i + 1, because j starts at 0, not 1, so there's the possibility for i to increase 1 more.
         */

        RemoveElement removeElement = new RemoveElement();
        int[] nums = {3,2,2,3};
        //int[] nums = {0,1,2,2,3,0,4,2}; 2
        System.out.println(removeElement.removeElement(nums, 3));
    }
}

/*
Answer:

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
 */
