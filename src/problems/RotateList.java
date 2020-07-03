package problems;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class RotateList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        List<Integer> firstList = new ArrayList<>();
        while (head != null) {
            firstList.add(head.val);
            head = head.next;
        }
        int[] arr = new int[firstList.size()];

        for (int i = 0; i < firstList.size(); i++) {
            arr[(i+k)%firstList.size()] = firstList.get(i);
        }
        List<ListNode> listNodes = new ArrayList<>();
        for (int value : arr) {
            listNodes.add(new ListNode(value));
        }
        for (int i = 0; i < listNodes.size(); i++) {
            if (i+1<listNodes.size()) {
                listNodes.get(i).next = listNodes.get(i+1);
            }
        }
        return listNodes.get(0);
    }

    public static void main(String[] args) {

        /*
        Given a linked list, rotate the list to the right by k places, where k is non-negative.

        Example 1:

        Input: 1->2->3->4->5->NULL, k = 2
        Output: 4->5->1->2->3->NULL
        Explanation:
        rotate 1 steps to the right: 5->1->2->3->4->NULL
        rotate 2 steps to the right: 4->5->1->2->3->NULL

        Example 2:

        Input: 0->1->2->NULL, k = 4
        Output: 2->0->1->NULL

        Explanation:

        rotate 1 steps to the right: 2->0->1->NULL
        rotate 2 steps to the right: 1->2->0->NULL
        rotate 3 steps to the right: 0->1->2->NULL
        rotate 4 steps to the right: 2->0->1->NULL
         */

        /*
        Plan:

        1. Make one pass over the linked list, and add each value to an array.
        2. Allocate another array and loop over the first array.
        3. newarr[i+k%2] = arr[i].
        4. Loop over the new array and create a ListNode for each index.
        5. Set an int variable equal to new array's length;
        6. While this int variable > 0, create a new ListNode whose value is equal to newarray[i], set ListNode equal
           to ListNode.next, decrement i.
         */

        RotateList rotateList = new RotateList();
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        System.out.println(rotateList.rotateRight(one, 2));
    }
}

/*
Answer:

    public ListNode rotateRight(ListNode head, int k) {
        List<Integer> firstList = new ArrayList<>();
        while (head != null) {
            firstList.add(head.val);
            head = head.next;
        }
        int[] arr = new int[firstList.size()];

        for (int i = 0; i < firstList.size(); i++) {
            arr[(i+k)%firstList.size()] = firstList.get(i);
        }
        List<ListNode> listNodes = new ArrayList<>();
        for (int value : arr) {
            listNodes.add(new ListNode(value));
        }
        for (int i = 0; i < listNodes.size(); i++) {
            if (i+1<listNodes.size()) {
                listNodes.get(i).next = listNodes.get(i+1);
            }
        }
        return listNodes.get(0);
    }
 */
