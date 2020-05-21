package problems;

public class NumberOfIslands {
    final static int[][] movements = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int numIslands(char[][] grid) {
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    counter++;
                    depthFirstSearch(grid, i, j);
                }
            }
        }
        return counter;
    }

    public static void depthFirstSearch(char[][] grid, int x, int y) {
        grid[x][y] = 0;
        for (int[] movement : movements) {
            int nextXPosition = x + movement[0];
            int nextYPosition = y + movement[1];
            if (isValid(grid, nextXPosition, nextYPosition)) {
                depthFirstSearch(grid, nextXPosition, nextYPosition);
            }
        }
    }

    public static boolean isValid(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1';
    }

    public static void main(String[] args) {

        /*
        Given a 2d grid map of '1's (land) and '0's (water),
        count the number of islands. An island is surrounded
        by water and is formed by connecting adjacent lands
        horizontally or vertically. You may assume all four
        edges of the grid are all surrounded by water.

        Example 1:

        Input:
        11110
        11010
        11000
        00000

        Output: 1

        Example 2:

        Input:
        11000
        11000
        00100
        00011

        Output: 3
         */

        /*
        Plan:

        1. We need a helper function that tells us whether a position isValid: within bounds of the 2D matrix and if it's 1.
        2. Since this is a 2D matrix, traversing it will involve 2 for loops. When the for loop hits a 1, we increase the counter.
        3. We use recursion in the form of DPS, and when it's done recurring for the 1 that the for loops found, we have flipped all
           positions of the island to 0 so we don't traverse and increment the counter again for other positions in the terrirtory of that
           particular island.
        4. In our 2 four loops, when we find a 1, we throw that position into the DPS to trace the perimeter of the island,
           setting positions to 0 so we don't traverse the same territory again.


        Bugs we made:

        1. Our isValid function did not check if position was '1'.
        2. We initially did not check for a character, we checked for int 1.
         */

        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        //char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};

        System.out.println(numIslands(grid));
    }
}


/*
Answer:

    public static int numIslands(char[][] grid) {
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    //increment counter by 1 to indicate an island has been found
                    counter++;
                    //now find the perimeter of the island
                    depthFirstSearch(grid, i, j);
                }
            }
        }
        return counter;
    }

    public static void depthFirstSearch(char[][] grid, int x, int y) {
        int[][] movements = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] movement : movements) {
            int nextXPosition = x + movement[0];
            int nextYPosition = y + movement[1];
            if (isValid(grid, nextXPosition, nextYPosition)) {
                //we've determined next movement is ok, so we flip it to zero to prevent
                //our function from going backward
                grid[nextXPosition][nextYPosition] = 0;
                //continue to define perimeter of island
                depthFirstSearch(grid, nextXPosition, nextYPosition);
            }
        }
    }

    public static boolean isValid(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1';
    }
 */
