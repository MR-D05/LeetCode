package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSumII {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] visited = new boolean[candidates.length];
        recur(candidates, visited, target, 0, 0, new ArrayList<>());
        return this.result;
    }

    public void recur(int[] candidates, boolean[] visited, int target, int sum, int position, List<Integer> set) {
        Collections.sort(set);
        if (sum == target && !this.result.contains(set)) {
            this.result.add(set);
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            List<Integer> temp = new ArrayList<>(set);
            visited = visited.clone();
            sum = total(temp);
            if (sum + candidates[i] <= target && !visited[i]) {
                visited[i] = true;
                temp.add(candidates[i]);
                recur(candidates, visited, target, total(temp), i, temp);
            }
        }
    }

    public int total(List<Integer> set) {
        int total = 0;
        for (int integer : set) {
            total += integer;
        }
        return total;
    }

    public static void main(String[] args) {
        /*
        Example 1:

        Input: candidates = [10,1,2,7,6,1,5], target = 8,
        A solution set is:
        [
          [1, 7],
          [1, 2, 5],
          [2, 6],
          [1, 1, 6]
        ]
        Example 2:

        Input: candidates = [2,5,2,1,2], target = 5,
        A solution set is:
        [
          [1,2,2],
          [5]
        ]


        [10,1,2,7,6,1,5]
8
         */
        int[] candidates = {10,1,2,7,6,1,5};

        CombinationSumII combinationSum = new CombinationSumII();

        System.out.println(combinationSum.combinationSum2(candidates, 8));
    }
}
