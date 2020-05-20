package problems;

import java.util.Stack;

public class Amazon {

    public static int blah = 1;
    public int blar = 1;


    public static int math(String string) {
        int result;
        Stack<Character> stack = new Stack<>();
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '/') {
                int temp;
                char first = stack.pop();
                temp = Integer.parseInt(String.valueOf(first)) / Integer.parseInt(String.valueOf(chars[i + 1]));
                char[] result1 = String.valueOf(temp).toCharArray();
                stack.push(result1[0]);
                i = i + 1;
            } else if (chars[i] == '*') {
                int temp;
                char first = stack.pop();
                temp = Integer.parseInt(String.valueOf(first)) * Integer.parseInt(String.valueOf(chars[i + 1]));
                char[] result1 = String.valueOf(temp).toCharArray();
                stack.push(result1[0]);
                i = i + 1;
            } else {
                stack.add(chars[i]);
            }
        }
        while (stack.size() != 1) {
            char first = stack.pop();
            char operator = stack.pop();
            char second = stack.pop();
            if (operator == '+') {
                result = Integer.parseInt(String.valueOf(first)) + Integer.parseInt(String.valueOf(second));
                char[] result1 = String.valueOf(result).toCharArray();
                stack.push(result1[0]);
            }
            if (operator == '-') {
                result = Integer.parseInt(String.valueOf(second)) - Integer.parseInt(String.valueOf(first));
                char[] result1 = String.valueOf(result).toCharArray();
                stack.push(result1[0]);
            }
        }
        return Integer.parseInt(String.valueOf(stack.get(0).charValue()));
    }

    public static void main(String[] args) {
        String string = "1+8-4/2*2";
        System.out.println(math(string));

        Amazon test = new Amazon();

        System.out.println(test.blar);
        System.out.println(test.blah);

        test.blah = 2;

        test.blar = 2;

        Amazon test2 = new Amazon();

        System.out.println(test2.blah);
        System.out.println(test2.blar);


    }
}
