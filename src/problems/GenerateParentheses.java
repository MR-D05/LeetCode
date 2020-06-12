package problems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        String current = "";
        backtrack(res, current, n, n);
        return res;
    }

    public void backtrack(List<String> res, String s, int open, int close) {
        if (open == 0 && close == 0) {
            res.add(s);
        }
        if (open > 0) {
            backtrack(res, s + "(", open - 1, close);
        }
        if (open < close) {
            backtrack(res, s + ")", open, close - 1);
        }
    }

    public static void main(String[] args) {

        /*
        Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

        For example, given n = 3, a solution set is:

        [
          "((()))",
          "(()())",
          "(())()",
          "()(())",
          "()()()"
        ]
         */

        /*
        Plan:

        1. We know that if we open a parentheses, we need to close it.
        2. We will use recursion.
        3. We have a class variable that each instance of the recursion can add strings to.
        4. We need to create a mechanism that sets in motion several instances of our recursive function.
        5. We have 3 conditions in our backtracking function based on two of its parameters: open and closed, which are of type int.
        6. These variables represent the number of the type of parentheses we have left to work with.
        7. Our backtracking function's 3 conditions are first, if open and closed are both 0, we add the string to the return list.
        8. Second, if our open variable is greater than 0, we add ( to the string and send that into another call, decrementing open.
        9. Third, and we want all these conditions to get hit, if open < closed, we add a ) to the string and send it into another call,
           decrementing closed.
         */

        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(3));
    }
}

/*
Answer:

    private static List<String> res;

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0 , n);
        return res;
    }

    public static void backtrack(List<String> res, String s, int open, int close, int max) {

        if (s.length() == max * 2) {
            res.add(s);
            return;
        }

        if (open < max) {
            backtrack(res, s + "(", open + 1, close, max);
        }

        if (close < open) {
            backtrack(res, s + ")", open, close + 1, max);
        }
    }
 */

