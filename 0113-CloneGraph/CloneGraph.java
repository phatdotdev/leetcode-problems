
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    public class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    HashMap<Node, Node> nodes = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        if (nodes.containsKey(node))
            return nodes.get(node);
        Node clone = new Node(node.val);
        nodes.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        return clone;
    }

}

/*
 * public Node cloneGraph(Node node) {
 * if (node == null)
 * return null;
 * HashMap<Node, Node> visited = new HashMap<>();
 * Node clone = new Node(node.val);
 * Queue<Node> queue = new LinkedList<>();
 * queue.offer(node);
 * visited.put(node, clone);
 * while (!queue.isEmpty()) {
 * Node current = queue.poll();
 * for (Node neighbor : current.neighbors) {
 * if (!visited.containsKey(neighbor)) {
 * visited.put(neighbor, new Node(neighbor.val));
 * queue.add(neighbor);
 * }
 * visited.get(current).neighbors.add(visited.get(neighbor));
 * }
 * }
 * return clone;
 * }
 */

/*
 * Map<Integer, Node> nodes = new HashMap<>();
 * 
 * public Node cloneGraph(Node node) {
 * if (nodes.containsKey(node.val))
 * return nodes.get(node.val);
 * ArrayList<Node> neighbors = new ArrayList<>();
 * for (Node neighbor : node.neighbors) {
 * neighbors.add(cloneGraph(neighbor));
 * }
 * Node clone = new Node(node.val, neighbors);
 * nodes.put(clone.val, clone);
 * return clone;
 * }
 */