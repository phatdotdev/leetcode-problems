public class SwapNodesInPair {
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

    public ListNode swapPairs(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            ListNode next = current.next.next;
            int tmp = current.val;
            current.val = current.next.val;
            current.next.val = tmp;
            current = next;
        }
        return head;
    }
}