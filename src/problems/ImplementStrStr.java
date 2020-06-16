package problems;

public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }
        int needleLength = needle.length();
        for (int i = 0; i < haystack.length(); i++) {
            if (needleLength + i < haystack.length() + 1) {
                if (haystack.substring(i, needleLength + i).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        /*
        Implement strStr().

        Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

        Example 1:

        Input: haystack = "hello", needle = "ll"
        Output: 2

        Example 2:

        Input: haystack = "aaaaa", needle = "bba"
        Output: -1
        Clarification:

        What should we return when needle is an empty string? This is a great question to ask during an interview.

        For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
         */

        /*
        Plan:

        1. Set an int variable to the length of the needle.
        2. Loop over the haystack with two inner conditions.
        3. If i + length of needle is less than length of haystack and then if substring of i and length of needle + 1
           matches needle, return i.
         */

        /*
        Problems:

        1. We achieved this one pretty quickly, but a few problems.
        2. We did not, per usual, consider the edge case, this one was the case if the needle equals the haystack, then
           return position 0 as that is the first and only occurrence of the needle.
        3. Also, we implemented the substring method of String, and we did not include haystack.length() + 1, we only
           considered haystack.length(), which
         */

        ImplementStrStr implementStrStr = new ImplementStrStr();
        String haystack = "hello";
        String needle = "ll";

//        String haystack = "aaaaa";
//        String needle = "bba";

        System.out.println(implementStrStr.strStr(haystack, needle));
    }
}

/*
Answer:


 */
