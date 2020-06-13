package problems.swapnodesinpairs;

public class SwapNodesInPairs {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return next == null ? "" + val : val + "," + next.toString();
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode currentStart = head;
        ListNode returnPointer = currentStart.next;
        while (true) {
            ListNode currentStartAdjacent = currentStart.next;
            ListNode nextCurrentStartPlaceholder = currentStartAdjacent.next;
            currentStartAdjacent.next = currentStart;
            if (nextCurrentStartPlaceholder == null || nextCurrentStartPlaceholder.next == null) {
                currentStart.next = nextCurrentStartPlaceholder;
                break;
            }
            currentStart.next = nextCurrentStartPlaceholder.next;
            currentStart = nextCurrentStartPlaceholder;
        }
        return returnPointer;
    }

    public static void main(String[] args) {

        /*
        Given a linked list, swap every two adjacent nodes and return its head.
        You may not modify the values in the list's nodes, only nodes itself may be changed.

        Example:

        Given 1->2->3->4, you should return the list as 2->1->4->3.
         */

        /*
        Plan:

        1. We start with two pointers: pointer1 and pointer2.
        2. We have a third temp pointer equal to pointer2.next.
        3. We set pointer2.next equal to pointer1, breaking the single link between pointer2 and its initial next value.
        4. We set pointer1.next equal to temp.next.
        5. Now, we set pointer1 equal to temp, and we set pointer2 equal to pointer1.next.
        6. We keep going like this and only break the while loop if temp or temp.next == null.
         */

        /*
        Problems/Revised Plan:

        1. Before the while loop we establish two pointers: we have pointer1, which is equal to head, and we have the returnPointer
           which will be pointer1.next, which makes sense, as we always want to start with the first node's next values as the start.
         */

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        System.out.println(swapPairs(one));
    }
}

/*
Answer:
    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode start = head;
        ListNode returnHead = start.next;
        while(true) {
            ListNode nextStart = start.next;
            ListNode temp = nextStart.next;
            nextStart.next = start;
            if (temp == null || temp.next == null) {
                start.next = temp;
                break;
            }
            start.next = temp.next;
            start = temp;
        }
        return returnHead;
    }
 */
