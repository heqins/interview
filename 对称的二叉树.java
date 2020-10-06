public class 对称的二叉树 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return helper(root, root);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;

        if (left == null || right == null) return false;

        if (left.val == right.val) {
            return helper(left.left, right.right) && helper(left.right, right.left);
        }

        return false;
    }
}
