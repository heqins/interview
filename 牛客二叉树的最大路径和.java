public class 牛客二叉树的最大路径和 {
    int max = Integer.MIN_VALUE;

    public int maxPathSum (TreeNode root) {
        // write code here
        if (root == null) return 0;

        helper(root);

        return max;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        int sum = root.val + left + right;

        max = Math.max(sum, max);

        return Math.max(left, right) + root.val;
    }
}
