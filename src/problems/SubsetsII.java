package problems;

import java.util.*;

public class SubsetsII {
    List<List<Integer>> result = new ArrayList<>();


    public List<List<Integer>> subsets(int[] nums) {
        HashMap<Integer, Integer> duplicates = findDuplicates(nums);
        this.recurse(nums, new ArrayList<>(), duplicates, 0);
        return this.result;
    }

    public void recurse(int[] nums, List<Integer> set, HashMap<Integer, Integer> duplicates, int length) {

        if (this.result.contains(set)) {
            return;
        }

        this.result.add(set);

        for (int i = length; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>(set);
            Collections.sort(temp);
            if (duplicates.containsKey(nums[i]) && temp.size() < nums.length) {
                int counter = 0;
                for (int integer : temp) {
                    if (nums[i] == integer) {
                        counter++;
                    }
                }
                if (counter < duplicates.get(nums[i])) {
                    temp.add(nums[i]);
                    this.recurse(nums, temp, duplicates, i);
                }
            }
            if (!temp.contains(nums[i]) && temp.size() <= nums.length) {
                temp.add(nums[i]);
                this.recurse(nums, temp, duplicates, i);
            }
        }
    }

    public HashMap<Integer, Integer> findDuplicates(int[] nums) {
        int counter = 0;
        HashMap<Integer, Integer> duplicates = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<nums.length; j++) {
                if (nums[i] == nums[j]) {
                    counter++;
                }
            }
            if (counter > 1) {
                duplicates.put(nums[i], counter);
            }
            counter = 0;
        }
        return duplicates;
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

        SubsetsII subsets = new SubsetsII();
        int[] nums = {5,5, 5, 5, 5};


        System.out.println(subsets.subsets(nums));
    }
}
