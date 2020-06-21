package problems;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {

        StringBuilder stringBuilder = new StringBuilder();
        int[] answer = new int[num1.length() + num2.length()];
        int carry = 0;
        int pos = 0;

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                answer[i + j + 1] += mul;
            }
        }

        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] += carry;
            carry = answer[i] / 10;
            answer[i] = answer[i] % 10;
        }

        for (int value : answer) {
            if (value == 0) {
                pos+=1;
            } else {
                break;
            }
        }

        for (int i = pos; i<answer.length; i++) {
            stringBuilder.append(answer[i]);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        /*
        Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

        Example 1:

        Input: num1 = "2", num2 = "3"
        Output: "6"

        Example 2:

        Input: num1 = "123", num2 = "456"
        Output: "56088"
        Note:

        The length of both num1 and num2 is < 110.
        Both num1 and num2 contain only digits 0-9.
        Both num1 and num2 do not contain any leading zero, except the number 0 itself.
        You must not use any built-in BigInteger library or convert the inputs to integer directly.
         */

        /*
        Plan:

        1. Important to know the bit value of chars.
        2. So, we have to convert the strings to char arrays.
        3. We create an int carry variable representing potential carried values from multiplication.
        4. We have two for loops that start from the last char in each char array.
        5. We make sure that char array with larger length is the outer for loop.
        6. We have a level int variable that starts at 1, and each iteration of our loops, we multiply level by 10.
        7. And we multiply our result by our level.
        8. We have an int result variable, which is the sum in each level, and a sum int variable that keeps track of our
           sum.
        9. So, we multiply our result by our level, add our result to our sum, zero out our result, and continue.
         */

        /*
        Problems:

        1. The above approach was a complete and utter failure.
        2. The answer becomes, we create an integer array that holds the product of the integers located at positions equal
           to i and j in the 2 for loops.
        3. The loops start from the last position until >= to zero.
        4. We update the int[] at position i + j + 1 to be += to the product.
        5. Now we loop over this int[] array and update each position starting from the last position to be % 10, but first we
           add an int carry variable, then we update the carry variable to be what's in that bucket / 10, then we update that
           element to be its contents % 10.
        6. We then have a position int variable and loop over the int[] again updating position if there are leading zeros.
        7. Finally, we loop over the int[] again starting at position, and append values to a StringBuilder and then return it to string.
         */

        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multiply("2", "3"));
    }
}
