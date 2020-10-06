public class 牛客平衡二叉树 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        return Math.abs(left - right) <= 1 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int getDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
