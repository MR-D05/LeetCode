package problems;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.recurse(candidates, target, 0, 0, new ArrayList<>());
        return result;
    }

    public void recurse(int[] candidates, int target, int sum, int position, List<Integer> set) {

        if (sum == target) {
            this.result.add(set);
            return;
        }

        for (int i = position; i < candidates.length; i++) {
            if (sum + candidates[position] <= target) {
                //part you need to understand better
                List<Integer> temp = new ArrayList<>(set);
                temp.add(candidates[i]);
                recurse(candidates, target, total(temp), i, temp);
            }
        }
    }

    public static int total(List<Integer> set) {
        int total = 0;
        for (int integer : set) {
            total += integer;
        }
        return total;
    }


    public static void main(String[] args) {
        /*
        Example 1:

        Input: candidates = [2,3,6,7], target = 7,
        A solution set is:
        [
          [7],
          [2,2,3]
        ]
        Example 2:

        Input: candidates = [2,3,5], target = 8,
        A solution set is:
        [
          [2,2,2,2],
          [2,3,3],
          [3,5]
        ]
         */

        int[] candidates = {2, 3, 6, 7};

        CombinationSum combinationSum = new CombinationSum();

        System.out.println(combinationSum.combinationSum(candidates, 7));
    }
}



/*
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        recurse(candidates, target, 0, new ArrayList<>(), 0);
        return result;
    }

    public void recurse(int[] candidates, int target, int sum, List<Integer> currentSet, int position) {

        if (sum == target) {
            result.add(currentSet);
            return;
        }

        for (int i = position; i < candidates.length; i++) {
            if (total(currentSet) + candidates[i] <= target) {
                List<Integer> temp = new ArrayList<>(currentSet);
                temp.add(candidates[i]);
                recurse(candidates, target, total(temp), temp, i);
            }
        }
    }

    public static int total(List<Integer> set) {
        int total = 0;
        for (int integer : set) {
            total += integer;
        }
        return total;
    }
 */
