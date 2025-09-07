
public class RemoveNthNodeFromEndOfList {

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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        int removeAt = length - n;
        if (removeAt == 0)
            return head.next;
        ListNode current = head;
        for (int i = 0; i < removeAt - 1; i++) {
            current = current.next;
        }

        current.next = current.next.next;
        return head;
    }
}
