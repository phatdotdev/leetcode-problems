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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];

            TreeNode node = stack.peek();
            if (preorderVal != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

}

/*
 * Map<Integer, Integer> inorderIndexMap = new HashMap<>();
 * int preorderIndex = 0;
 * 
 * public TreeNode buildTree(int[] preorder, int[] inorder) {
 * for (int i = 0; i < inorder.length; i++) {
 * inorderIndexMap.put(inorder[i], i);
 * }
 * return buildSubtree(preorder, 0, inorder.length - 1);
 * }
 * 
 * public TreeNode buildSubtree(int[] preorder, int left, int right) {
 * if (left > right)
 * return null;
 * int rootValue = preorder[preorderIndex++];
 * TreeNode root = new TreeNode(rootValue);
 * int inorderRootIndex = inorderIndexMap.get(rootValue);
 * root.left = buildSubtree(preorder, left, inorderRootIndex - 1);
 * root.right = buildSubtree(preorder, inorderRootIndex + 1, right);
 * return root;
 * }
 */