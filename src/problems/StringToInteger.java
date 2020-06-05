package problems;

import java.util.ArrayList;
import java.util.List;

public class StringToInteger {

    public static int myAtoi(String str) {
        str = str.trim();

        if (str.length() == 0 || (str.length() == 1 && (str.charAt(0) == '-' || str.charAt(0) == '+'))) {
            return 0;
        }

        List<Character> list = new ArrayList<>();
        list.add('0');
        list.add('1');
        list.add('2');
        list.add('3');
        list.add('4');
        list.add('5');
        list.add('6');
        list.add('7');
        list.add('8');
        list.add('9');

        int position = 0;

        StringBuilder stringBuilder = new StringBuilder();

        if (str.charAt(position) == '-' || str.charAt(position) == '+') {
            stringBuilder.append(str.charAt(0));
            position += 1;
        }

        if (!list.contains(str.charAt(position))) {
            return 0;
        }

        while (position < str.length() && list.contains(str.charAt(position))) {
            stringBuilder.append(str.charAt(position));
            position += 1;
        }

        if (stringBuilder.toString().charAt(0) == '-') {
            try {
                return Integer.parseInt(stringBuilder.toString());
            } catch (NumberFormatException e) {
                return Integer.MIN_VALUE;
            }
        } else {
            try {
                return Integer.parseInt(stringBuilder.toString());
            } catch (NumberFormatException e) {
                return Integer.MAX_VALUE;
            }
        }
    }

    public static void main(String[] args) {

        /*
        Implement atoi which converts a string to an integer.

        The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

        The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

        If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

        If no valid conversion could be performed, a zero value is returned.

        Note:

        Only the space character ' ' is considered as whitespace character.
        Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.

        Example 1:

        Input: "42"
        Output: 42
        Example 2:

        Input: "   -42"
        Output: -42
        Explanation: The first non-whitespace character is '-', which is the minus sign.
        Then take as many numerical digits as possible, which gets 42.

        Example 3:

        Input: "4193 with words"
        Output: 4193
        Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.

        Example 4:

        Input: "words and 987"
        Output: 0
        Explanation: The first non-whitespace character is 'w', which is not a numerical
        digit or a +/- sign. Therefore no valid conversion could be performed.

        Example 5:

        Input: "-91283472332"
        Output: -2147483648
        Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
        Therefore INT_MIN (−231) is returned.
         */

        /*
        Plan:

        1. Create a HashMap with 0-9.
        2. Trim the string first, then check if first character is +/-.
        3. Then, create a variable that is the position and a while loop.
        4. While map contains charAt position continue.
        5. Create a StringBuilder.
        6. If first char after trim is not +/-, return 0.
        7. Else, add the +/- to the StringBuilder.
        8. While map contains charAt position, add to StringBuilder.
        9. Now we have an if/else statement with two try/catch statements.
        10. If charAt 0 is -, then try to parse int and return it, catch NumberFormatException, return INT_MIN.
        11. Else, try to parse int and return it, catch NumberFormatException, return INT_MAX.

        Problems:

        1. Several problems: we trimmed the string but didn't set the trimmed string to the string, so that would have been ignored.
        2. Also, we need to do that at the very beginning.
        3. Per usual, we did not consider the edge cases, which go right after the trimming.
        4. These are, if the length of the string is 0 or the length is 1 and that 1 char is either a - or a +, return 0;
         */

        System.out.println(myAtoi("-   1"));
    }
}
