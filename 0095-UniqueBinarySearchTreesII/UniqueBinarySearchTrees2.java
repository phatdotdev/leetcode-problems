
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueBinarySearchTrees2 {
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

    /* MEMORY */

    Map<String, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> generateTreeNodes(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {
        String key = start + "," + end;
        if (memo.containsKey(key))
            return memo.get(key);
        List<TreeNode> trees = new ArrayList<>();
        if (start > end) {
            trees.add(null);
        } else if (start == end) {
            trees.add(new TreeNode(start));
        } else {
            for (int curr = start; curr <= end; curr++) {
                List<TreeNode> lefts = generate(start, curr - 1);
                List<TreeNode> rights = generate(curr + 1, end);
                for (TreeNode left : lefts) {
                    for (TreeNode right : rights) {
                        TreeNode root = new TreeNode(curr);
                        root.left = left;
                        root.right = right;
                        trees.add(root);
                    }
                }
            }
        }
        memo.put(key, trees);
        return trees;
    }
}

/*
 * public List<TreeNode> generateTrees(int n) {
 * return generate(1, n);
 * }
 * 
 * private List<TreeNode> generate(int start, int end) {
 * List<TreeNode> trees = new ArrayList<>();
 * if (start > end) {
 * trees.add(null);
 * return trees;
 * }
 * if (start == end) {
 * trees.add(new TreeNode(start));
 * return trees;
 * }
 * for (int i = start; i <= end; i++) {
 * List<TreeNode> lefts = generate(start, i - 1);
 * List<TreeNode> rights = generate(i + 1, end);
 * for (TreeNode left : lefts) {
 * for (TreeNode right : rights) {
 * TreeNode root = new TreeNode(i);
 * root.left = left;
 * root.right = right;
 * trees.add(root);
 * }
 * }
 * }
 * return trees;
 * }
 */