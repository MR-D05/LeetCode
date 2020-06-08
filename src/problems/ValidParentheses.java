package problems;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('(', ')');
        hashMap.put('{', '}');
        hashMap.put('[', ']');
        hashMap.put(')', '(');
        hashMap.put('}', '{');
        hashMap.put(']', '[');
        for (char character : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (hashMap.get(character) == stack.peek()) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(character);
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {

        /*
        Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

        An input string is valid if:

        Open brackets must be closed by the same type of brackets.
        Open brackets must be closed in the correct order.
        Note that an empty string is also considered valid.

        Example 1:

        Input: "()"
        Output: true

        Example 2:

        Input: "()[]{}"
        Output: true

        Example 3:

        Input: "(]"
        Output: false

        Example 4:

        Input: "([)]"
        Output: false

        Example 5:

        Input: "{[]}"
        Output: true
         */

        /*
        Plan:

        1. Setup a HashMap of Character, Character with each Character as key, and its reflection as value.
        2. We will use a Stack here.
        3. We loop over the the string to char array.
        4. Our successful circumstance is if the Stack is empty at the end of our process.
        5. In our for loop, we say that if the stack is not empty, get the value from the hashmap of the char in the loop,
           and if that value is equal to stack.peek(), then pop it off the stack and continue to loop.
        6. Return the result of the question of whether the stack is empty.
         */

        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("{[]}"));
    }
}

/*
Answer:

    public static boolean isValid(String s) {

        HashMap<Character, Character> hashMap = new HashMap<>();

        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');

        char[] charArray = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char chars : charArray) {
            if (!stack.isEmpty()) {
                if (hashMap.get(chars) == stack.peek()) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(chars);
        }
        return stack.isEmpty();
    }
 */
