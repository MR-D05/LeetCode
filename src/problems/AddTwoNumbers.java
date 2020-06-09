//This is yet another test

package problems;

import java.math.BigInteger;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> firstStack = new Stack<>();
        Stack<Integer> secondStack = new Stack<>();
        StringBuilder firstString = new StringBuilder();
        StringBuilder secondString = new StringBuilder();
        BigInteger number;
        String resultString;
        ListNode finalListNode = new ListNode(0);
        ListNode pointer = finalListNode;

        while (l1 != null) {
            firstStack.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            secondStack.push(l2.val);
            l2 = l2.next;
        }

        while (!firstStack.isEmpty()) {
            firstString.append(firstStack.pop().toString());
        }

        while (!secondStack.isEmpty()) {
            secondString.append(secondStack.pop().toString());
        }

        BigInteger one = new BigInteger(firstString.toString());
        BigInteger two = new BigInteger(secondString.toString());

        number = one.add(two);

        resultString = number.toString();

        for (int i = resultString.length() - 1; i >= 0; i--) {
            pointer.next = new ListNode(Integer.parseInt(String.valueOf(resultString.charAt(i))));
            pointer = pointer.next;
        }
        return finalListNode.next;
    }

    public static void main(String[] args) {

        //This is a test

        /*
        You are given two non-empty linked lists representing two non-negative integers.
        The digits are stored in reverse order and each of their nodes contain a single digit.
        Add the two numbers and return it as a linked list.

        You may assume the two numbers do not contain any leading zero, except the number 0 itself.

        Example:

        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 0 -> 8
        Explanation: 342 + 465 = 807.
         */

        /*
        Plan:
        1. While each node does not equal null, add to a stack.
        2. While each stack does not equal null, add to string.
        3. Add strings as integers together.
        4. Cast to string again.
        5. Make a new node with value 0.
        6. Create a new node that points to node above.
        7. For each char in string, node.next = new node of its integer value.
        8. Set node = node.next.
        9. Return original node.next.

        Problems:
        1. Plan above did not reverse the final number value, so it created a listnode from first number to last instead of last to first.
           The solution was in the for loop to start from last character and descend instead of 0 to last.
        2. Original solution does not consider large numbers; therefore, this solution needs to use BigInteger.
         */

        ListNode one = new ListNode(1);
        ListNode nine1 = new ListNode(9);
        ListNode nine2 = new ListNode(9);
        ListNode nine3 = new ListNode(9);
        ListNode nine4 = new ListNode(9);
        ListNode nine5 = new ListNode(9);
        ListNode nine6 = new ListNode(9);
        ListNode nine7 = new ListNode(9);
        ListNode nine8 = new ListNode(9);
        ListNode nine9 = new ListNode(9);

        ListNode nine10 = new ListNode(9);

        one.next = nine1;
        nine1.next = nine2;
        nine2.next = nine3;
        nine3.next = nine4;
        nine4.next = nine5;
        nine5.next = nine6;
        nine6.next = nine7;
        nine7.next = nine8;
        nine8.next = nine9;

        System.out.println(addTwoNumbers(nine10, one));
    }
}

/*
Answer:

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder number1 = new StringBuilder("");
        StringBuilder number2 = new StringBuilder("");

        if (l1.next == null) {
            number1.append(l1.val);
        } else {
            while (l1.next != null) {
                number1.append(l1.val);
                l1 = l1.next;
                if (l1.next == null) {
                    number1.append(l1.val);
                }
            }
        }

        if (l2.next == null) {
            number2.append(l2.val);
        } else {
            while (l2.next != null) {
                number2.append(l2.val);
                l2 = l2.next;
                if (l2.next == null) {
                    number2.append(l2.val);
                }
            }
        }

        String string1 = new String(number1);
        String string2 = new String(number2);


        char[] ch1 = string1.toCharArray();
        char[] temp1 = new char[ch1.length];
        for (int i = 0; i < ch1.length; i++) {
            temp1[temp1.length - i - 1] = ch1[i];
        }

        char[] ch2 = string2.toCharArray();
        char[] temp2 = new char[ch2.length];
        for (int i = 0; i < ch2.length; i++) {
            temp2[temp2.length - i - 1] = ch2[i];
        }

        String finalString1 = String.copyValueOf(temp1);

        String finalString2 = String.copyValueOf(temp2);

        BigDecimal parsedInteger0;
        BigDecimal parsedInteger1;

        if (finalString1.isEmpty()) {
            parsedInteger0 = new BigDecimal(0);
        } else {
            parsedInteger0 = new BigDecimal(finalString1);
        }

        if (finalString2.isEmpty()) {
            parsedInteger1 = new BigDecimal(0);
        } else {
            parsedInteger1 = new BigDecimal(finalString2);
        }

        BigDecimal sum = parsedInteger0.add(parsedInteger1);

        String finalDigits = sum.toString();

        char[] ch3 = finalDigits.toCharArray();
        char[] temp3 = new char[ch3.length];
        for (int i = 0; i < ch3.length; i++) {
            temp3[temp3.length - i - 1] = ch3[i];
        }

        ListNode returnListNode = new ListNode(temp3[0]);

        List<ListNode> listOfListNodes = new ArrayList<ListNode>();

        for (char c : temp3) {
            ListNode newNode = new ListNode(Integer.parseInt(Character.toString(c)));
            listOfListNodes.add(newNode);
        }

        for (int i = 0; i < listOfListNodes.size() - 1; i++) {
            listOfListNodes.get(i).next = listOfListNodes.get(i + 1);
        }

        System.out.print(sum);

        return listOfListNodes.get(0);
    }
 */
