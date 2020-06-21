package problems;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {

        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        char[] larger = getLargerNumber(chars1, chars2);
        char[] smaller = getSmallerNumber(chars1, chars2);
        int result = 0;
        int carry = 0;
        int sum = 0;
        int levelSum = 0;
        int sumPower = 1;
        int levelSumPower = 1;

        for (int i = larger.length - 1; i >= 0; i--) {
            for (int j = smaller.length - 1; j >= 0; j--) {
                sum = (larger[i] - '0') * (smaller[j] - '0') + carry;
                carry = 0;
                if (sum > 10) {
                    carry = sum / 10;
                    levelSum += (sum - 10) * levelSumPower;
                } else {
                    levelSum += sum * levelSumPower;
                }
                sum = 0;
                levelSumPower *= 10;
            }
            levelSum *= sumPower;
            result += levelSum;
            sumPower *= 10;
            levelSum = 0;
            levelSumPower = 1;
        }

        return String.valueOf(result);
    }

    public char[] getLargerNumber(char[] chars1, char[] chars2) {
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] > chars2[i]) {
                return chars1;
            } else if (chars2[i] > chars1[i]) {
                return chars2;
            }
        }
        return chars1;
    }

    public char[] getSmallerNumber(char[] chars1, char[] chars2) {
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] > chars2[i]) {
                return chars2;
            } else if (chars2[i] > chars1[i]) {
                return chars1;
            }
        }
        return chars1;
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



        "123"
        "456"
         */

        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multiply("12", "12"));
    }
}
