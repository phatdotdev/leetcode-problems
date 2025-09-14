public class ReverseNodesInKGroup {

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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;
        ListNode dummy = new ListNode(0, head);
        ListNode prevGroup = dummy;
        ListNode end = dummy;
        while (true) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null)
                break;
            ListNode start = prevGroup.next;
            ListNode nextGroup = end.next;
            end.next = null;
            prevGroup.next = reverse(start);
            start.next = nextGroup;
            prevGroup = start;
            end = start;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null, current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

}

/*
 * public ListNode reverseKGroup(ListNode head, int k) {
 * int[] tmp = new int[k];
 * ListNode current = head;
 * ListNode prev = head;
 * int count = 0;
 * while (current != null) {
 * count++;
 * tmp[k - count] = current.val;
 * if (count == k) {
 * for (int i = 0; i < k; i++) {
 * prev.val = tmp[i];
 * prev = prev.next;
 * }
 * count = 0;
 * }
 * current = current.next;
 * }
 * return head;
 * }
 */