package problems;

public class RemoveNthNodeFromEndOfList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return next != null ? "" + val + ", " + next.toString() : "" + val;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || (n == 1 && head.next == null)) {
            return null;
        }
        int counter = 1;
        int secondCounter = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;

        while (dummy.next != null) {
            counter++;
            dummy = dummy.next;
        }

        ListNode temp2 = temp;

        while (temp2.next != null) {
            secondCounter++;
            if (secondCounter == counter - n) {
                temp2.next = temp2.next.next;
                break;
            }
            temp2 = temp2.next;
        }
        return temp.next;
    }

    public static void main(String[] args) {

        /*
        Given a linked list, remove the n-th node from the end of list and return its head.

        Example:

        Given linked list: 1->2->3->4->5, and n = 2.

        After removing the second node from the end, the linked list becomes 1->2->3->5.

        Note:

        Given n will always be valid.

        Follow up:

        Could you do this in one pass?
         */

        /*
        Plan:

        1. Pass through the linked list once and get a counter of how many there are.
        2. Now, a second pass through until you get to counter + 1 - n.
        3. In our second pass through we also have a counter.
        4. We say if the counter is at target-1, we say that node's next is the one after the one after it.
         */

        /*
        Problems:

        1. We were kind of close.
        2. We had set up our dummy ListNode after we did our first pass through, so we had modified head irrevocably.
        3. We needed 3 ListNodes: a dummy ListNode of value 0 with its next set to head and another dummy that pointed to the first dummy's next.
        4. The last one we return in the end, we return lastDummy's next, which points to the head of firstDummy, which gives us the ability to
           traverse firstDummy, updating its state.
         */
//
//        ListNode one = new ListNode(9);
//        ListNode two = new ListNode(0);
//        ListNode three = new ListNode(3);
//        ListNode one1 = new ListNode(8);
//        ListNode two2 = new ListNode(7);
//        ListNode three3 = new ListNode(3);
//        ListNode one4 = new ListNode(8);
//        ListNode two5 = new ListNode(6);
//        ListNode three6 = new ListNode(3);
//        ListNode four = new ListNode(1);
//
//        one.next = two;
//        two.next = three;
//        three.next = one1;
//        one1.next = two2;
//        two2.next = three3;
//        three3.next = one4;
//        one4.next = two5;
//        two5.next = three6;
//        three6.next = four;


        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
//        ListNode three = new ListNode(3);
//        ListNode four = new ListNode(4);
//        ListNode five = new ListNode(5);

        one.next = two;
//        two.next = three;
//        three.next = four;
//        four.next = five;

        System.out.println(removeNthFromEnd(one, 1));
    }
}

/*
Answer:
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "" + val + (next == null ? "" : ", " + next.toString());
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int counter = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;

        while (first.next != null) {
            counter++;
            first = first.next;
        }

        first = dummy;
        int length = (counter -= n);

        while (length > 0) {
            length--;
            first = first.next;
        }

        first.next = first.next.next;

        return dummy.next;
    }
 */
