package problems;

public class LongestPalindromicSubstringTest {

    public static String getLongestPalindromicSubstring(String s) {

        if (s.length() == 0) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length() - 1; i++) {
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

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


    public static void main(String[] args) {
        System.out.println(getLongestPalindromicSubstring("cbbd"));
    }
}
