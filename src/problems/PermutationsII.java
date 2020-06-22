package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    List<List<Integer>> returnList = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        recur(nums, new ArrayList<>(), visited);
        return returnList;
    }

    public void recur(int[] nums, List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length && !returnList.contains(list)) {
            returnList.add(list);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            List<Integer> tempList = new ArrayList<>(list);
            boolean[] tempVisited = visited.clone();
            if (!tempVisited[i]) {
                tempList.add(nums[i]);
                tempVisited[i] = true;
                recur(nums, tempList, tempVisited);
            }
        }
    }

    public static void main(String[] args) {

        /*
        Given a collection of numbers that might contain duplicates, return all possible unique permutations.

        Example:

        Input: [1,1,2]
        Output:
        [
          [1,1,2],
          [1,2,1],
          [2,1,1]
        ]
         */

        /*
        Plan:

        1. We create a recursive function. The base case is if the list argument's length == num.length, and our return list of lists
           does not contain it, we add it to the list of lists and return.
        2. After that condition, we have a for loop that loops over nums with the condition that if i == position argument, continue,
           else add it to our temp list that has been created based on the list argument and feed it back to the call with a record of i,
           which lets us know which element.
        3. This won't work, we need a memory of all positions seen. So, maybe each call accepts a unique to it boolean array that holds
           the memory of indices visited, and our conditino is if element i of that boolean array is false, we add it to the list, mark
           it as true, and feed it to the recursive call.
        4. So, we need to create a new list based on list argument, an a new list of boolean based on the list of boolean argument.

         */

        PermutationsII permutationsII = new PermutationsII();
        int[] nums = {1, 1, 2};
        System.out.println(permutationsII.permuteUnique(nums));

    }
}

/*
Answer:

    List<List<Integer>> returnList = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        recur(nums, new ArrayList<>(), visited);
        return returnList;
    }

    public void recur(int[] nums, List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length && !returnList.contains(list)) {
            returnList.add(list);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            List<Integer> tempList = new ArrayList<>(list);
            boolean[] tempVisited = visited.clone();
            if (!tempVisited[i]) {
                tempList.add(nums[i]);
                tempVisited[i] = true;
                recur(nums, tempList, tempVisited);
            }
        }
    }
 */
