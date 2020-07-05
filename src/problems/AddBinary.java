package problems;

public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            //int sum = ((Integer.parseInt(String.valueOf(a.charAt(i)))) + (Integer.parseInt(String.valueOf(b.charAt(i))))) + carry;
            int sum = ((a.charAt(i) - '0') + (b.charAt(i) - '0')) + carry;
            carry = 0;
            carry = sum / 2;
            stringBuilder.append(sum % 2);
        }
        stringBuilder.append(carry);
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {

        /*
        Given two binary strings, return their sum (also a binary string).

        The input strings are both non-empty and contains only characters 1 or 0.

        Example 1:

        Input: a = "11", b = "1"
        Output: "100"

        Example 2:

        Input: a = "1010", b = "1011"
        Output: "10101"
         */

        /*
        Plan:

        1. This will be much like MultiplyStrings.
        2. We have a StringBuilder that holds are result.
        3. We have two for loops starting at their last indices.
        4. Using the trick of subtracting char '0' from our considered char, we get the integer value we need.
        5. We have an int carry variable and at each step calculating our sum we say carry is equal to sum / 2, and
           to our StringBuilder we add sum modulo 2.
        6. Finally, we return our StringBuilder reversed toString.
         */

        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("1010", "1011"));
    }
}

/*
Answer:

 */
