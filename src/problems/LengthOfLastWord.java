package problems;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int counter = 0;
        if (s.length() == 0) {
            return counter;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                continue;
            } else {
                while (s.charAt(i) != ' ') {
                    counter++;
                    i--;
                    if (i == -1) {
                        return counter;
                    }
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {

        /*
        Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length
        of last word (last word means the last appearing word if we loop from left to right) in the string.

        If the last word does not exist, return 0.

        Note: A word is defined as a maximal substring consisting of non-space characters only.

        Example:

        Input: "Hello World"

        Output: 5
         */

        /*
        Plan:

        1. If s.length() == 0, return 0.
        2. Loop over string to char from last to first.
        3. Our condition is if char == ' ', we continue, else while char != ' ', counter++, return counter.
        4. We have an int counter.
         */

        /*
        Problems:

        1. First, within the while loop we did i++ not i--.
        2. Also, we didn't account for the fact that we would decrement i, and i could possibly be -1, throwing an index
           out of bounds exception.
         */

        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord("a"));
    }
}

/*
Answer:

    public int lengthOfLastWord(String s) {
        int counter = 0;
        if (s.length() == 0) {
            return counter;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                continue;
            } else {
                while (s.charAt(i) != ' ') {
                    counter++;
                    i--;
                    if (i == -1) {
                        return counter;
                    }
                }
            }
        }
        return counter;
    }
 */
