package problems;

public class CountAndSay {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return recur(n, "1");
    }

    public String recur(int n, String string) {
        if (n == 1) {
            return string;
        } else {
            StringBuilder stringBuilder = new StringBuilder(string);
            StringBuilder nextString = new StringBuilder();
            int counter = 1;
            for (int i = 0; i < stringBuilder.length(); i++) {
                if (i + 1 < stringBuilder.length()) {
                    if (stringBuilder.charAt(i) == stringBuilder.charAt(i + 1)) {
                        counter++;
                    } else {
                        nextString.append(counter);
                        nextString.append(stringBuilder.charAt(i));
                        counter = 1;
                    }
                } else {
                    nextString.append(counter);
                    nextString.append(stringBuilder.charAt(i));
                    return recur(n - 1, nextString.toString());
                }
            }
        }
        return string;
    }

    public static void main(String[] args) {

        /*
        The count-and-say sequence is the sequence of integers with the first five terms as following:

        1.     1
        2.     11
        3.     21
        4.     1211
        5.     111221
        1 is read off as "one 1" or 11.
        11 is read off as "two 1s" or 21.
        21 is read off as "one 2, then one 1" or 1211.

        Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. You can do so recursively,
        in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.

        Note: Each term of the sequence of integers will be represented as a string.

        Example 1:

        Input: 1
        Output: "1"
        Explanation: This is the base case.

        Example 2:

        Input: 4
        Output: "1211"
        Explanation: For n = 3 the term was "21" in which we have two groups "2" and "1", "2" can be read as "12" which
        means frequency = 1 and value = 2, the same way "1" is read as "11", so the answer is the concatenation of "12" and "11" which is "1211".
         */

        /*
        Plan:

        1. Create a recursive function that accepts an int count variable, and a String variable.
        2. This function will have an int counter variable and operate like, looping over the length of the String,
           if (i+1<string.length), if charAt(i) == charAt(i+1), counter++, else, while counter > 0, string+=charAt(i), counter--.
        3. Finally, after the for loop, recur with string and count.
        4. The recursive function will first check if n == 0 then return the string, else, do the for loop.

         */


        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(4));
    }
}
