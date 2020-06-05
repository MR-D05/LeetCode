package problems;

public class ReverseInteger {

    public static int reverse(int x) {
        String test = Integer.toString(x);
        char[] chars = test.toCharArray();
        char[] copy = new char[chars.length];
        if (x < 0) {
            copy[0] = chars[0];
            for (int i = chars.length - 1; i >= 1; i--) {
                if (i == chars.length - 1 && chars[i] == 0) {
                    continue;
                }
                if (chars[i] == 0 && chars[i + 1] == 0) {
                    continue;
                }
                copy[copy.length - i] = chars[i];

                // -12345

                // -00000

                // length is 6

                //6-5 = 1; 6-5 = 2

            }
            StringBuilder finalString = new StringBuilder();
            for (char charsd : copy) {
                finalString.append(charsd);
            }
            try {
                return Integer.parseInt(finalString.toString());
            } catch (NumberFormatException e) {
                return 0;
            }
        } else {
            for (int i = chars.length - 1; i >= 0; i--) {
                if (i == chars.length - 1 && chars[i] == 0) {
                    continue;
                }
                if (chars[i] == 0 && chars[i + 1] == 0) {
                    continue;
                }
                copy[copy.length - 1 - i] = chars[i];
            }
            StringBuilder finalString = new StringBuilder();
            for (char charsd : copy) {
                finalString.append(charsd);
            }
            try {
                return Integer.parseInt(finalString.toString());
            } catch (NumberFormatException e) {
                return 0;
            }
        }
    }

    public static void main(String[] args) {

        /*
        Given a 32-bit signed integer, reverse digits of an integer.

        Example 1:

        Input: 123
        Output: 321

        Example 2:

        Input: -123
        Output: -321

        Example 3:

        Input: 120
        Output: 21

        Note:
        Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
        range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
         */

        /*
        Plan:
        1. Determine if x is less than 0.
        2. If it is, then to String it, and then to char it, then create a new char[] and going backward to index 1,
           fill the new array. Then set index 0 to the - char. Then to string, then to int.
        3. Also, when going backward, if first char is '0', continue, and if i is not the last char, and i is zero and chart to right is 0,
           continue.
        4. Else, copy to empty char array at position empty char array length - i.
        5. Also, first, for the negative int case, copy char[0] to new char[0] for the '-'.
        6. For the negative int case, when looping over char array, loop it on the condition nof i>=1.
        6. For positive, since we don't have '-', do it for i>=0, and copy to char[length-1-i].
        7. Now we have a char array with what we want, so we make a StringBuilder and add each char to it.
        8. Now to account for NumberFormatException in the case that the reverse of the given int is no longer an int, we set up
           a try catch catching the NumberFormatException and in that case returning 0, else we return the StringBuilder to string and
           Integer.parsing that.
         */

        System.out.print(reverse(123000));
    }

}

/*
Answer:

    public static int reverse(int x) {
        int integer = x;
        if (integer < 0) {
            integer = Math.abs(integer);
            StringBuilder integerStringAbsoluteValue = new StringBuilder(String.valueOf(Integer.toString(integer).toCharArray()));
            try {
                int number = Integer.parseInt(integerStringAbsoluteValue.reverse().toString());
                return number - 2 * number;
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        StringBuilder integerStringAbsoluteValue = new StringBuilder(String.valueOf(Integer.toString(integer).toCharArray()));
        try {
            return Integer.parseInt(integerStringAbsoluteValue.reverse().toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
 */
