package problems;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        this.recurse(nums, new ArrayList<>());
        return this.result;
    }

    public void recurse(int[] nums, List<Integer> set) {

        if (set.size() == nums.length) {
            this.result.add(set);
            return;
        }

        for (int num : nums) {
            if (!set.contains(num)) {
                List<Integer> temp = new ArrayList<>(set);
                temp.add(num);
                recurse(nums, temp);
            }
        }
    }

    public static void main(String[] args) {

        /*
        Example:

        Input: [1,2,3]
        Output:
        [
          [1,2,3],
          [1,3,2],
          [2,1,3],
          [2,3,1],
          [3,1,2],
          [3,2,1]
        ]
         */

        Permutations permutations = new Permutations();
        int[] nums = {1, 2, 3};
        System.out.println(permutations.permute(nums));
    }
}
