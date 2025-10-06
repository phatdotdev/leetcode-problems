
import java.util.Stack;

public class BSTIterator {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null)
            pushLeft(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/*
 * public class BSTIterator {
 * public class TreeNode {
 * public int val;
 * public TreeNode left;
 * public TreeNode right;
 * 
 * public TreeNode() {
 * }
 * 
 * public TreeNode(int val) {
 * this.val = val;
 * }
 * 
 * public TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 * 
 * private Queue<Integer> queue;
 * 
 * public BSTIterator(TreeNode root) {
 * queue = new LinkedList<>();
 * makeQueue(root);
 * }
 * 
 * private void makeQueue(TreeNode node) {
 * if (node != null) {
 * makeQueue(node.left);
 * queue.offer(node.val);
 * makeQueue(node.right);
 * }
 * }
 * 
 * public int next() {
 * return queue.poll();
 * }
 * 
 * public boolean hasNext() {
 * return !queue.isEmpty();
 * }
 * }
 * 
 */
