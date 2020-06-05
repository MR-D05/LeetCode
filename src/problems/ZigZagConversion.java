package problems;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        StringBuilder string = new StringBuilder();
        StringBuilder returnString = new StringBuilder();
        boolean goingDown = false;
        int currentRow = 0;
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        for (char chars : s.toCharArray()) {
            string.append(chars);
        }
        for (int i = 0; i < string.length(); i++) {
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            list.get(currentRow).append(string.charAt(i));
            currentRow += goingDown ? 1 : -1;
        }
        for (StringBuilder stringBuilder : list) {
            returnString.append(stringBuilder);
        }
        return returnString.toString();
    }

    public static void main(String[] args) {

        /*
        The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
        (you may want to display this pattern in a fixed font for better legibility)

        P   A   H   N
        A P L S I I G
        Y   I   R

        And then read line by line: "PAHNAPLSIIGYIR"

        Write the code that will take a string and make this conversion given a number of rows:

        string convert(string s, int numRows);

        Example 1:

        Input: s = "PAYPALISHIRING", numRows = 3
        Output: "PAHNAPLSIIGYIR"

        Example 2:

        Input: s = "PAYPALISHIRING", numRows = 4
        Output: "PINALSIGYAHRPI"
        Explanation:

        P     I    N
        A   L S  I G
        Y A   H R
        P     I
         */

        /*
        Plan:

        1. Create a list of StringBuilder for each row.
        2. Create a StringBuilder of the given string to char array.
        3. Loop over this StringBuilder.
        4. Create a boolean variable that tells you whether you are going down or not.
        5. Create a variable that indicates which row you are on in the traversal.
        6. Our condition in the for loop is if currentRow == 0, then going down is flipped.
        7. Before end of each iteration, if we are going down, then add 1 to currentRow, else add -1.
        8. Get StringBuilder from list at currentRow, add the character at position i of the StringBuilder of the given string.

        Problems:

        1. You forgot the edge case when numRows == 1, as the first iteration of the for loop over the given string will add 1,
           then the next iteration will try to access non-existent StringBuilder at currentRow == 1 when there is only a StringBuilder
           at currentRow == 0 in the list.

         */


        System.out.println(convert("PAYPALISHIRING", 4));
    }
}

/*
Answer:
    public static String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> list = new ArrayList<>();

        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            list.add(new StringBuilder());
        }

        boolean goingDown = false;
        int currentRow = 0;

        StringBuilder letters = new StringBuilder();

        letters.append(s.toCharArray());

        for (int i = 0; i < letters.length(); i++) {
            list.get(currentRow).append(letters.charAt(i));

            if (currentRow == 0 || currentRow == list.size() - 1) {
                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder returnString = new StringBuilder();

        for (StringBuilder row : list) {
            returnString.append(row);
        }

        return returnString.toString();
    }
 */

