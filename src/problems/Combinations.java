package problems;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> masterSet = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        recur(n, k, 0, new ArrayList<>());
        return masterSet;
    }

    public void recur(int n, int k, int index, List<Integer> set) {
        if (set.size() == k) {
            masterSet.add(new ArrayList<>(set));
            return;
        }
        for (int i = index + 1; i <= n; i++) {
            set.add(i);
            recur(n, k, i, set);
            set.remove(set.size() - 1);
        }
    }

    public static void main(String[] args) {

        /*
        Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

        Example:

        Input: n = 4, k = 2

        Output:
        [
          [2,4],
          [3,4],
          [2,3],
          [1,2],
          [1,3],
          [1,4],
        ]
         */

        /*
        Plan:

        1. We need some sort of mechanism to determine if a combination already exists in our result set.
        2. We come across [2,1] and we need a way to say we can't do that that because we already have [1,2].
        3. We implement a DFS algorithm.
        4. In this function, it will use recursion.
        5. 2 base cases are, if n is less than index, return, and if set's size is equal to k, add to master set a new
           array list of the set and return.
        6. Otherwise, for loop starting at i+1 and less than or equal to n, add i to set, and throw back into DFS and finally
           remove the last element.
         */

        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4, 2));
    }
}

/*
Answer:

    List<List<Integer>> masterSet = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        recur(n, k, 0, new ArrayList<>());
        return masterSet;
    }

    public void recur(int n, int k, int index, List<Integer> set) {
        if (set.size() == k) {
            masterSet.add(new ArrayList<>(set));
            return;
        }
        for (int i = index + 1; i <= n; i++) {
            set.add(i);
            recur(n, k, i, set);
            set.remove(set.size() - 1);
        }
    }

 */
