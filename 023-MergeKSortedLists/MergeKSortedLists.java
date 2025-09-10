
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public class ListNode {
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            current.next = min;
            current = current.next;

            if (min.next != null) {
                pq.offer(min.next);
            }
        }
        return dummy.next;
    }
}

/*
 * public ListNode mergeKLists(ListNode[] lists) {
 * if (lists == null || lists.length == 0)
 * return null;
 * ListNode res = null;
 * for (ListNode l : lists) {
 * res = mergeTwoLists(res, l);
 * }
 * return res;
 * }
 * 
 * private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
 * ListNode dummy = new ListNode(0);
 * ListNode current = dummy;
 * while (l1 != null && l2 != null) {
 * if (l1.val <= l2.val) {
 * current.next = l1;
 * l1 = l1.next;
 * } else {
 * current.next = l2;
 * l2 = l2.next;
 * }
 * current = current.next;
 * }
 * current.next = (l1 != null) ? l1 : l2;
 * return dummy.next;
 * }
 */

/*
 * BEST WAY
 * public ListNode mergeKLists(ListNode[] lists) {
 * if (lists == null || lists.length == 0)
 * return null;
 * return mergeRange(lists, 0, lists.length - 1);
 * }
 * 
 * private ListNode mergeRange(ListNode[] lists, int left, int right) {
 * if (left == right)
 * return lists[left];
 * int mid = left + (right - left) / 2;
 * ListNode l1 = mergeRange(lists, left, mid);
 * ListNode l2 = mergeRange(lists, mid + 1, right);
 * return mergeTwoLists(l1, l2);
 * }
 * 
 * private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
 * ListNode dummy = new ListNode(0);
 * ListNode current = dummy;
 * while (l1 != null && l2 != null) {
 * if (l1.val <= l2.val) {
 * current.next = l1;
 * l1 = l1.next;
 * } else {
 * current.next = l2;
 * l2 = l2.next;
 * }
 * current = current.next;
 * }
 * current.next = (l1 != null) ? l1 : l2;
 * return dummy.next;
 * }
 */