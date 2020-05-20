package problems;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        this.recurse(nums, new ArrayList<>(), 0);
        return this.result;
    }

    public void recurse(int[] nums, List<Integer> set, int length) {

        if (this.result.contains(set)) {
            return;
        }

        this.result.add(set);

        for (int i = length; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>(set);
            if (!temp.contains(nums[i]) && temp.size() <= nums.length) {
                temp.add(nums[i]);
                this.recurse(nums, temp, i);
            }
        }
    }

    public static void main(String[] args) {
        /*
        Example:

        Input: nums = [1,2,3]
        Output:
        [
          [3],
          [1],
          [2],
          [1,2,3],
          [1,3],
          [2,3],
          [1,2],
          []
        ]
         */

        Subsets subsets = new Subsets();
        int[] nums = {1, 2, 3};
        System.out.println(subsets.subsets(nums));
    }
}
