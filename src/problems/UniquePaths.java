package problems;

public class UniquePaths {

    public int uniquePaths(int m, int n) {

        // m is number of rows and n is number of columns
        // we create a new 2D integer array sized based on the uniquePaths' arguments
        // this array will be a cache of the answers to our subproblems

        //we divide the problem into subproblems as we realize that the answer to the question
        //how many unique path are there to any given space on the board is the sum
        //of the number of unique paths to the space above and to the right of the current
        //position

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }


    public static void main(String[] args) {

        /*
        For this problem, we have a 2D matrix as an input
        and we are asked how many unique paths are there from 0,0 to
        the bottom right-most index of the matrix if we are only allowed
        to move right or down at any given point
         */

        int[][] board =
                {
                        {1, 1, 1, 1, 1, 1, 1},
                        {1, 2, 3, 4, 5, 6, 7},
                        {1, 3, 1, 4, 5, 6, 7}
                };

        UniquePaths uniquePaths = new UniquePaths();
        System.out.print(uniquePaths.uniquePaths(3, 7));
    }
}
