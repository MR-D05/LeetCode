package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ValidSoduko {

    public boolean isValidSudoku(char[][] board) {

        int finalCounter = -1;
        int counter;

        HashMap<Integer, List<Character>> rows = new HashMap<>();
        HashMap<Integer, List<Character>> columms = new HashMap<>();
        HashMap<Integer, List<Character>> tiles = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            tiles.put(i, new ArrayList<>());
            columms.put(i, new ArrayList<>());
            rows.put(i, new ArrayList<>());
        }


        for (int i = 0; i < board.length; i++) {
            if (i % 3 == 0) {
                finalCounter = i;
            }
            counter = finalCounter;
            for (int j = 0; j < board.length; j++) {
                if (j == 3) {
                    counter++;
                }
                if (j == 6) {
                    counter++;
                }
                if (board[i][j] != '.' && rows.get(i).contains(board[i][j])) {
                    return false;
                }
                if (board[i][j] != '.' && columms.get(j).contains(board[i][j])) {
                    return false;
                }
                rows.get(i).add(board[i][j]);
                columms.get(j).add(board[i][j]);
                if (j < 3) {
                    if (board[i][j] != '.' && tiles.get(counter).contains(board[i][j])) {
                        return false;
                    }
                    tiles.get(counter).add(board[i][j]);
                }
                if (j >= 3 && j < 6) {
                    if (board[i][j] != '.' && tiles.get(counter).contains(board[i][j])) {
                        return false;
                    }
                    tiles.get(counter).add(board[i][j]);
                }
                if (j >= 6) {
                    if (board[i][j] != '.' && tiles.get(counter).contains(board[i][j])) {
                        return false;
                    }
                    tiles.get(counter).add(board[i][j]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        /*
        Example 1:

        Input:
        [
          ['5','3','.','.','7','.','.','.','.'],
          ['6','.','.','1','9','5','.','.','.'],
          ['.','9','8','.','.','.','.','6','.'],
          ['8','.','.','.','6','.','.','.','3'],
          ['4','.','.','8','.','3','.','.','1'],
          ['7','.','.','.','2','.','.','.','6'],
          ['.','6','.','.','.','.','2','8','.'],
          ['.','.','.','4','1','9','.','.','5'],
          ['.','.','.','.','8','.','.','7','9']
        ]
        Output: true
        Example 2:

        Input:
        [
          ['8','3','.','.','7','.','.','.','.'],
          ['6','.','.','1','9','5','.','.','.'],
          ['.','9','8','.','.','.','.','6','.'],
          ['8','.','.','.','6','.','.','.','3'],
          ['4','.','.','8','.','3','.','.','1'],
          ['7','.','.','.','2','.','.','.','6'],
          ['.','6','.','.','.','.','2','8','.'],
          ['.','.','.','4','1','9','.','.','5'],
          ['.','.','.','.','8','.','.','7','9']
        ]
        Output: false
        Explanation: Same as Example 1, except with the 5 in the top left corner being
            modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.



        [
            ['.','.','4','.','.','.','6','3','.'],
            ['.','.','.','.','.','.','.','.','.'],
            ['5','.','.','.','.','.','.','9','.'],
            ['.','.','.','5','6','.','.','.','.'],
            ['4','.','3','.','.','.','.','.','1'],
            ['.','.','.','7','.','.','.','.','.'],
            ['.','.','.','5','.','.','.','.','.'],
            ['.','.','.','.','.','.','.','.','.'],
            ['.','.','.','.','.','.','.','.','.']
        ]
         */

        ValidSoduko validSoduko = new ValidSoduko();

        char[][] input =
                {
                        {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };
//                {
//
//                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//                };

//                {
//                        {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
//                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                        {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
//                        {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
//                        {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
//                        {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
//                        {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
//                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
//                };


        System.out.println(validSoduko.isValidSudoku(input));
    }
}
