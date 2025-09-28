import java.util.HashMap;

public class CopyListWithRandomPointer {

    public class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    HashMap<Node, Node> visited = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node clone = new Node(head.val);
        visited.put(head, clone);
        clone.next = copyRandomList(head.next);
        clone.random = visited.get(head.random);
        return clone;
    }
}
