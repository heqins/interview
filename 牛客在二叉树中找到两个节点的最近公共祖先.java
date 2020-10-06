public class 牛客在二叉树中找到两个节点的最近公共祖先 {
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        TreeNode res = dfs(root, o1, o2);

        return res.val;
    }

    public TreeNode dfs(TreeNode root, int o1, int o2) {
        if (root == null) return null;

        if (root.val == o1 || root.val == o2) return root;

        TreeNode left = dfs(root.left, o1, o2);

        TreeNode right = dfs(root.right, o1, o2);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return root;
    }
}
