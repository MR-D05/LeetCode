package problems;

public class RomanToInteger {

    public static int romanToInt(String s) {

        /*
        I can be placed before V (5) and X (10) to make 4 and 9.
        X can be placed before L (50) and C (100) to make 40 and 90.
        C can be placed before D (500) and M (1000) to make 400 and 900.
         */

        int returnValue = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length()) {
                if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') {
                    returnValue += 4;
                    i = i + 1;
                    continue;
                } else if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'X') {
                    returnValue += 9;
                    i = i + 1;
                    continue;
                } else if (s.charAt(i) == 'X' && s.charAt(i + 1) == 'L') {
                    returnValue += 40;
                    i = i + 1;
                    continue;
                } else if (s.charAt(i) == 'X' && s.charAt(i + 1) == 'C') {
                    returnValue += 90;
                    i = i + 1;
                    continue;
                } else if (s.charAt(i) == 'C' && s.charAt(i + 1) == 'D') {
                    returnValue += 400;
                    i = i + 1;
                    continue;
                } else if (s.charAt(i) == 'C' && s.charAt(i + 1) == 'M') {
                    returnValue += 900;
                    i = i + 1;
                    continue;
                }
            }

            if (s.charAt(i) == 'I') {
                returnValue += 1;
            } else if (s.charAt(i) == 'V') {
                returnValue += 5;
            } else if (s.charAt(i) == 'X') {
                returnValue += 10;
            } else if (s.charAt(i) == 'L') {
                returnValue += 50;
            } else if (s.charAt(i) == 'C') {
                returnValue += 100;
            } else if (s.charAt(i) == 'D') {
                returnValue += 500;
            } else if (s.charAt(i) == 'M') {
                returnValue += 1000;
            }
        }
        return returnValue;
    }


    public static void main(String[] args) {
        /*
        Example 1:

        Input: "III"
        Output: 3
        Example 2:

        Input: "IV"
        Output: 4
        Example 3:

        Input: "IX"
        Output: 9
        Example 4:

        Input: "LVIII"
        Output: 58
        Explanation: L = 50, V= 5, III = 3.
        Example 5:

        Input: "MCMXCIV"
        Output: 1994
        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
         */

        System.out.println(romanToInt("IX"));
    }
}
