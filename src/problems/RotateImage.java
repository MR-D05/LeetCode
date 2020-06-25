package problems;

import java.util.Arrays;

public class RotateImage {

    public void rotate(int[][] matrix) {

        int k = 0;
        int l = matrix.length - 1;
        boolean[][] visited = new boolean[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) continue;
                if (visited[i][j] && visited[j][i]) continue;
                swap(matrix, visited, i, j);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            while (k < l) {
                int temp = matrix[i][k];
                matrix[i][k] = matrix[i][l];
                matrix[i][l] = temp;
                k++;
                l--;
            }
            k = 0;
            l = matrix.length - 1;
        }
    }

    public void swap(int[][] matrix, boolean[][] visited, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
        visited[i][j] = true;
        visited[j][i] = true;
    }

    public static void main(String[] args) {

            /*
            You are given an n x n 2D matrix representing an image.

            Rotate the image by 90 degrees (clockwise).

            Note:

            You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
            DO NOT allocate another 2D matrix and do the rotation.

            Example 1:

            Given input matrix =
            [
              [1,2,3],
              [4,5,6],
              [7,8,9]
            ],

            rotate the input matrix in-place such that it becomes:
            [
              [7,4,1],
              [8,5,2],
              [9,6,3]
            ]

            Example 2:

            Given input matrix =
            [
              [ 5, 1, 9,11],
              [ 2, 4, 8,10],
              [13, 3, 6, 7],
              [15,14,12,16]
            ],

            rotate the input matrix in-place such that it becomes:
            [
              [15,13, 2, 5],
              [14, 3, 4, 1],
              [12, 6, 8, 9],
              [16, 7,10,11]
            ]
             */

            /*
            Plan:

            1. Two steps: one pass through will turn columns into rows and vice versa; second will using a two-pointer approach,
               swap from out to in.
            2. For the first step we need a way to tell if two indices have been swapped already, and we will just skip if i == j.
             */

        RotateImage rotateImage = new RotateImage();
//        int[][] matrix =
//                {
//                        {5, 1, 9, 11},
//                        {2, 4, 8, 10},
//                        {13, 3, 6, 7},
//                        {15, 14, 12, 16}
//                };

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotateImage.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}

/*
Answer:

    public void rotate(int[][] matrix) {

        int k = 0;
        int l = matrix.length - 1;
        boolean[][] visited = new boolean[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) continue;
                if (visited[i][j] && visited[j][i]) continue;
                swap(matrix, visited, i, j);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            while (k < l) {
                int temp = matrix[i][k];
                matrix[i][k] = matrix[i][l];
                matrix[i][l] = temp;
                k++;
                l--;
            }
            k = 0;
            l = matrix.length - 1;
        }
    }

    public void swap(int[][] matrix, boolean[][] visited, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
        visited[i][j] = true;
        visited[j][i] = true;
    }
 */
