import java.util.ArrayList;
import java.util.List;

public class InsertionSortList {

    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        ListNode tail = dummy;
        while (curr != null) {
            ListNode next = curr.next;
            if (curr.val >= tail.val) {
                tail.next = curr;
                tail = curr;
                tail.next = null;
            } else {
                ListNode prev = dummy;
                while (prev.next != null && prev.next.val < curr.val) {
                    prev = prev.next;
                }
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = next;
        }
        return dummy.next;
    }
}

/*
 * public ListNode insertionSortList(ListNode head) {
 * List<ListNode> list = new ArrayList<>();
 * ListNode curr = head;
 * while (curr != null) {
 * list.add(curr);
 * curr = curr.next;
 * }
 * list.sort((a, b) -> a.val - b.val);
 * ListNode dummy = new ListNode(0);
 * ListNode prev = dummy;
 * curr = list.get(0);
 * for (ListNode node : list) {
 * prev.next = node;
 * prev = node;
 * }
 * prev.next = null;
 * return dummy.next;
 * }
 */

/*
 * public ListNode insertionSortList(ListNode head) {
 * if (head == null)
 * return null;
 * ListNode dummy = new ListNode(0);
 * ListNode curr = head;
 * while (curr != null) {
 * ListNode prev = dummy;
 * while (prev.next != null && prev.next.val < curr.val) {
 * prev = prev.next;
 * }
 * ListNode next = curr.next;
 * curr.next = prev.next;
 * prev.next = curr;
 * curr = next;
 * }
 * return dummy.next;
 * }
 */