package problems;

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


public class MergeTwoSortedLists {

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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 != null) {
            temp.next = l1;
        }
        if (l2 != null) {
            temp.next = l2;
        }
        return head.next;
    }

    /*
    Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together
    the nodes of the first two lists.

    Example:

    Input: 1->2->4, 1->3->4
    Output: 1->1->2->3->4->4
     */

    /*
    Plan:

    1. We have a ListNode variable that is a new ListNode of value 0.
    2. We have another ListNode variable that points to the other one.
    3. We have a while loop with condition l1 != null && l2 != null.
    4. Inside we have an if/else flow: if l1.val < l2.val, dummy.val = l1.val, else dummy.val = l2.val.
    5. We update in both section of the if/else where we are considering the l1/l2 ListNodes.
    6. Outside the if/else, we update position of dummy.
    7. Finally, we will be in a position where one list has been moved to the next position after its last non-null node,
       and the other will be at its last non-null node.
    8. So, outside of the while loop we will have 2 more if statements: if l1 != null, then dummy.next = l1, and similarly,
       if l2 != null, dummy.next = l2.
     */

    /*
    Problems:

    1. Attempting to catalogue the problems I encountered as there were MANY.
    2. It appears I still do not understand pointers.
    3. All I can really do now is record the errors I made, not exactly how they were wrong and what I put in was right.
    4. First, at line 42, I had: "temp.val = l1.val"
    5. Then I had "temp = l1"
    6. Only after those two failures did I do what was right: "temp.next = l1.next"
     */

    public static void main(String[] args) {

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode four = new ListNode(4);

        one.next = two;
        two.next = four;

        ListNode one2 = new ListNode(1);
        ListNode three = new ListNode(3);
        ListNode four2 = new ListNode(4);

        one2.next = three;
        three.next = four2;

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        System.out.println(mergeTwoSortedLists.mergeTwoLists(one, one2));
    }
}
