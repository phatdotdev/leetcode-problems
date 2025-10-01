public class SortList {
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

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return mergeList(left, right);
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

}

/*
 * public ListNode sortList(ListNode head) {
 * if (head == null)
 * return null;
 * ListNode dummy = new ListNode(Integer.MIN_VALUE);
 * ListNode tail = dummy;
 * while (head != null) {
 * ListNode next = head.next;
 * if (tail == dummy || head.val >= tail.val) {
 * tail.next = head;
 * tail = head;
 * tail.next = null;
 * } else {
 * ListNode node = dummy;
 * while (node.next != null && node.next.val < head.val) {
 * node = node.next;
 * }
 * head.next = node.next;
 * node.next = head;
 * }
 * head = next;
 * }
 * return dummy.next;
 * }
 */

/*
 * public ListNode sortList(ListNode head) {
 * if (head == null)
 * return null;
 * ListNode dummy = new ListNode(Integer.MIN_VALUE);
 * ListNode curr = head;
 * while (curr != null) {
 * ListNode next = curr.next;
 * ListNode node = dummy;
 * while (node.next != null && node.next.val < curr.val) {
 * node = node.next;
 * }
 * curr.next = node.next;
 * node.next = curr;
 * curr = next;
 * }
 * return dummy.next;
 * }
 */