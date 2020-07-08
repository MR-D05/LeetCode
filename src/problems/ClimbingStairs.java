package problems;

import java.util.HashMap;

public class ClimbingStairs {
    HashMap<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        this.cache.put(0, 1);
        this.cache.put(1, 1);
        return helper(n);
    }

    public int helper(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int first = helper(n - 1);
        int second = helper(n - 2);
        cache.put(n - 1, first);
        cache.put(n - 2, second);
        return first + second;
    }

    public static void main(String[] args) {

        /*
        You are climbing a stair case. It takes n steps to reach to the top.

        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

        Example 1:

        Input: 2
        Output: 2

        Explanation: There are two ways to climb to the top.

        1. 1 step + 1 step
        2. 2 steps

        Example 2:

        Input: 3
        Output: 3

        Explanation: There are three ways to climb to the top.

        1. 1 step + 1 step + 1 step
        2. 1 step + 2 steps
        3. 2 steps + 1 step
         */

        /*
        Plan:

        1. I am thinking Fibonacci type recursion, but will have to try to see if it's working.
        2. My idea is that since we know that if there are 2 stairs, the answer is 2, so that can be our base case.
        3. So with our base case and the knowledge that if there were 1 step it would be one, we say return climbStairs(n-1);
         */

        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(3));
    }
}

/*
Answer:

    HashMap<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        this.cache.put(0, 1);
        this.cache.put(1, 1);
        return helper(n);
    }

    public int helper(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int first = helper(n - 1);
        int second = helper(n - 2);
        cache.put(n - 1, first);
        cache.put(n - 2, second);
        return first + second;
    }
 */
