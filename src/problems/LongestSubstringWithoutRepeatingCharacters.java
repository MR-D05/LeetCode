package problems;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {

        if (s.length() < 2) return s.length();

        List<Character> list = new ArrayList<>();
        int maxLen = 1;
        int cursor = -1;

        for (int i = 0; i < s.length(); i++) {
            if (!list.contains(s.charAt(i))) {
                list.add(s.charAt(i));
            } else {
                maxLen = Math.max(maxLen, list.size());
                list = new ArrayList<>();
                cursor = cursor + 1;
                i = cursor;
            }
        }
        maxLen = Math.max(maxLen, list.size());
        return maxLen;
    }

    public static void main(String[] args) {
        /*
        Given a string, find the length of the longest substring without repeating characters.

        Example 1:

        Input: "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.
        Example 2:

        Input: "bbbbb"
        Output: 1
        Explanation: The answer is "b", with the length of 1.
        Example 3:

        Input: "pwwkew"
        Output: 3
        Explanation: The answer is "wke", with the length of 3.
        Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

        "dvdf"
         */

        /*
        Plan:

        1. Edge case: if string length is less than 2, return its length.
        2. Create variables: a list of characters, a maxlength, and a cursor.
        3. Now, for loop over the string with condition: if the list does not contain the char at position i, then add it to the list.
        4. Otherwise, maxLen is Math.max of itself or size of the list.
        5. Now to move the process, we set cursor equal to itself plus one.
        6. Cursor is initialized to -1, because in the loop, when we first add one to cursor to make it 0, it goes back into the loop
           and increments one before doing anything else, so we want it at -1 to begin with.
        7. We then set i equal to cursor so that we are then considering the beginning of the string plus one to the right.

         */
        System.out.print(lengthOfLongestSubstring("abcabcbb"));
    }
}

/*
Answer:

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();

        int maxLen = 1;
        int cursor = 0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= cursor) {
                cursor = map.get(c) + 1;
            } else {
                maxLen = (int)Math.max(maxLen, i - cursor + 1);
            }
            map.put(c, i);
        }

        return maxLen;
    }
 */
