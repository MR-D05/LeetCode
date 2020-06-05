package problems;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String string = Integer.toString(x);
        int left;
        int right;
        if (string.length() % 2 == 0) {
            left = string.length() / 2 - 1;
        } else {
            left = string.length() / 2;
        }
        right = string.length() / 2;
        return isPalindrome(string, left, right);
    }

    public static boolean isPalindrome(String x, int left, int right) {
        while (left >= 0 && right < x.length() && x.charAt(left) == x.charAt(right)) {
            left--;
            right++;
        }
        return left == -1;
    }

    public static void main(String[] args) {

        /*
        Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

        Example 1:

        Input: 121
        Output: true

        Example 2:

        Input: -121
        Output: false

        Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

        Example 3:

        Input: 10
        Output: false

        Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

        Follow up:
        Coud you solve it without converting the integer to a string?
         */

        /*
        Plan:

        1. If argument is less than zero return false?
        2. Turn int to string, set variables for left and right based on length of string.
        3. Set up helper function that will determine if string is palindrome. It accepts string, left right.
        4. It returns true if right + left == length.
         */


        System.out.println(isPalindrome(1001));
    }
}

/*
Answer:

    public static boolean isPalindrome(int x) {
        String argumentAsString = Integer.toString(x);
        int left;
        int right;
        if (argumentAsString.length() % 2 == 0) {
            left = argumentAsString.length() / 2 - 1;
        } else {
            left = argumentAsString.length() / 2;
        }
        right = argumentAsString.length() / 2;
        return isPalindrome(argumentAsString, left, right);
    }

    public static boolean isPalindrome(String x, int left, int right) {
        while (left >= 0 && right < x.length() && x.charAt(left) == x.charAt(right)) {
            left--;
            right++;
        }
        return left == -1 && right == x.length();
    }

 */
