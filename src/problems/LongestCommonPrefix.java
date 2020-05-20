package problems;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        StringBuilder returnValue = new StringBuilder();

        String longestString = strs[0];
        String shortestString = strs[0];

        for (String string : strs) {
            longestString = string.length() > longestString.length() ? string : longestString;
            shortestString = string.length() < shortestString.length() ? string : shortestString;
        }

        for (int i = 0; i < shortestString.length(); i++) {
            for (String string : strs) {
                if (string.charAt(i) != shortestString.charAt(i)) {
                    return returnValue.toString();
                }
            }
            returnValue.append(shortestString.charAt(i));
        }

        return returnValue.toString();
    }

    public static void main(String[] args) {

        /*
        Example 1:

        Input: ["flower","flow","flight"]
        Output: "fl"
        Example 2:

        Input: ["dog","racecar","car"]
        Output: ""
        Explanation: There is no common prefix among the input strings.
         */


        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

        String[] strs = {"dog","racecar","car"};

        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }
}
