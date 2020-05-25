package problems;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int length1 = expandFromCenter(s, i, i);
            int length2 = expandFromCenter(s, i, i + 1);
            int length = Math.max(length1, length2);
            if (length > end - start) {
                start = i - (length - 1) / 2;
                end = i + (length / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {

        /*
        Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

        Example 1:

        Input: "babad"
        Output: "bab"
        Note: "aba" is also a valid answer.
        Example 2:

        Input: "cbbd"
        Output: "bb"
         */

        /*
        Plan:

        1. We have one for loop over the length of the string.
        2. We have a helper function that expands from center of all substrings we test.
        3. In order to cover the two cases of substrings with even and odd lengths, for each iteration of the for loop
           we invoke the helper twice with different values for left and right positions in the substring.
        4. Ultimately we will return s.substring a beginning and end variable, so we need to set these.
        5. The idea is to update the beginning we will subtract from i (the center) half of the length, and add to it
           half of the length to get the end.
        6. To be honest, I am still not sure why this is the answer, but to find the start of any iteration, we do
           i - (length - 1) / 2 and the end will be i + length / 2. Why is it length - 1? I still do not get that intuitively,
           and that usually means it will stump me the next time I try to solve this.


        Problems:
        1. If division has a remainder, ints round DOWN.
        2. Substrings start where you intuitively think they start, and end + 1.
        3. How do we know where the start is?
         */


        System.out.println(longestPalindrome("cbb"));
    }

}

/*
Answer:

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int length1 = expandFromCenter(s, i, i);
            int length2 = expandFromCenter(s, i, i + 1);
            int length = Math.max(length1, length2);
            if (length > end - start) {
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandFromCenter(String s, int left, int right) {

        if (s.length() == 0 || left > right) {
            return 0;
        }

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}

 */
