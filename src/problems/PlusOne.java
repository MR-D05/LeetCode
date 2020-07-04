package problems;

import java.util.Arrays;

public class PlusOne {

    public int[] plusOne(int[] digits) {

        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]+=1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] returnValue = new int[digits.length+1];
        returnValue[0] = 1;
        return returnValue;
    }

    public static void main(String[] args) {

        /*
        Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

        The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

        You may assume the integer does not contain any leading zero, except the number 0 itself.

        Example 1:

        Input: [1,2,3]
        Output: [1,2,4]
        Explanation: The array represents the integer 123.

        Example 2:

        Input: [4,3,2,1]
        Output: [4,3,2,2]

        Explanation: The array represents the integer 4321.
         */

        /*
        Plan:

        1. This solution works. Can we implement the other one?
        2. The other one goes like: we loop over digits starting from the last digit.
        3. Condition within the loop is if digits[i] is not 9, we add one to it and return digits.
        4. Else we set it equal to 0.
        5. Now, at the end of this for loop, if we haven't returned digits, we have a scenario where
           digits is like for example [0, 0, 0, 0].
        6. So we allocated a new int[] that is one more than the length of digits and set the first index
           to 1 and return it.

         */

        PlusOne plusOne = new PlusOne();
        int[] digits = {9, 9, 9};
        System.out.println(Arrays.toString(plusOne.plusOne(digits)));
    }
}
/*
Answer:

    public int[] plusOne(int[] digits) {
        StringBuilder stringBuilder = new StringBuilder();
        String s = "";
        for (int ints : digits) {
            stringBuilder.append(ints);
        }
        BigDecimal bigDecimal = new BigDecimal(stringBuilder.toString());
        bigDecimal = bigDecimal.add(BigDecimal.valueOf(1));
        s = bigDecimal.toString();
        char[] chars = s.toCharArray();
        int[] ints = new int[chars.length];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        return ints;
    }
 */
