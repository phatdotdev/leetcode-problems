
import java.util.List;

public class ReorderList {

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

    private ListNode left;

    public void reorderList(ListNode head) {
        left = head;
        reorderHelper(head.next);
    }

    public void reorderHelper(ListNode right) {
        if (right == null)
            return;
        reorderHelper(right.next);
        if (left == null)
            return;
        if (left == right || left.next == right) {
            right.next = null;
            left = null;
        } else {
            ListNode tmp = left.next;
            left.next = right;
            right.next = tmp;
            left = tmp;
        }
    }

}

/*
 * public void reorderList(ListNode head) {
 * if (head == null || head.next == null)
 * return;
 * ListNode fast = head, slow = head;
 * while (fast != null && fast.next != null) {
 * slow = slow.next;
 * fast = fast.next.next;
 * }
 * ListNode prev = null, curr = slow.next;
 * slow.next = null;
 * while (curr != null) {
 * ListNode tmp = curr.next;
 * curr.next = prev;
 * prev = curr;
 * curr = tmp;
 * }
 * ListNode first = head, second = prev;
 * while (second != null) {
 * ListNode tmp1 = first.next, tmp2 = second.next;
 * first.next = second;
 * second.next = tmp1;
 * first = tmp1;
 * second = tmp2;
 * }
 * }
 */