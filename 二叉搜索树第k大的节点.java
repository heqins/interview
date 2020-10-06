public class 二叉搜索树第k大的节点 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    private int count = 0;
    private int res = 0;

    public int kthLargest(TreeNode root, int k) {
        helper(root, k);
        return res;
    }

    public void helper(TreeNode root, int k) {
        helper(root.left, k);
        if (count == k) {
            res = root.val;
        }
        count++;
        helper(root.right, k);
    }
}
