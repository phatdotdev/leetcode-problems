
import java.util.Stack;

public class ConstructBinaryTree {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {

        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0)
            return null;
        int n = postorder.length;
        TreeNode root = new TreeNode(postorder[n - 1]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        int inorderIndex = n - 1;
        for (int i = postorder.length - 2; i >= 0; i--) {
            int posVal = postorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(posVal);
                stack.push(node.right);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(posVal);
                stack.push(node.left);
            }
        }
        return root;
    }
}
