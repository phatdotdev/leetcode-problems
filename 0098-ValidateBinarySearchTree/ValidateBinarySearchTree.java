public class ValidateBinarySearchTree {
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

    public boolean isValidBST(TreeNode root) {
        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        return dfs(root, min, max);
    }

    public boolean dfs(TreeNode node, int min, int max) {
        if (node == null)
            return true;

        if (node.left != null && (node.left.val >= node.val || node.left.val < min))
            return false;
        if (node.right != null && (node.right.val <= node.val || node.right.val > max))
            return false;
        return dfs(node.left, min, node.val - 1) && dfs(node.right, node.val + 1, max);
    }
}
