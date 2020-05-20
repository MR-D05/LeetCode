package problems;

public class PalindromeNumber {

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

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
