package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeroes {

    public static class Coordinate {
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void setZeroes(int[][] matrix) {
        List<Coordinate> list = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new Coordinate(i, j));
                }
            }
        }

        for (Coordinate coordinate : list) {
            setZeroes(matrix, coordinate.x, coordinate.y);
        }

    }

    public void setZeroes(int[][] matrix, int x, int y) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == x) {
                    matrix[i][j] = 0;
                }
                if (j == y) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        /*
        Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

        Example 1:

        Input:
        [
          [1,1,1],
          [1,0,1],
          [1,1,1]
        ]

        Output:
        [
          [1,0,1],
          [0,0,0],
          [1,0,1]
        ]

        Example 2:

        Input:
        [
          [0,1,2,0],
          [3,4,5,2],
          [1,3,1,5]
        ]

        Output:
        [
          [0,0,0,0],
          [0,4,5,0],
          [0,3,1,0]
        ]

        Follow up:

        A straight forward solution using O(mn) space is probably a bad idea.
        A simple improvement uses O(m + n) space, but still not the best solution.
        Could you devise a constant space solution?
         */

        /*
        Plan:

        1.
         */

        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
//        int[][] matrix = {
//                {0, 1, 2, 0},
//                {3, 4, 5, 2},
//                {1, 3, 1, 5}
//        };

        int[][] matrix = {
            {1,1,1},
            {1,0,1},
            {1,1,1}
        };
        setMatrixZeroes.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}

/*
Answer:

    public static class Coordinate {
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void setZeroes(int[][] matrix) {
        List<Coordinate> list = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new Coordinate(i, j));
                }
            }
        }

        for (Coordinate coordinate : list) {
            setZeroes(matrix, coordinate.x, coordinate.y);
        }

    }

    public void setZeroes(int[][] matrix, int x, int y) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == x) {
                    matrix[i][j] = 0;
                }
                if (j == y) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
 */
