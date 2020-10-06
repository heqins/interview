public class 牛客二叉搜索树的第k个节点 {
    int count = 0;
    TreeNode res;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null) return null;

        helper(pRoot, k);

        return res;
    }

    public void helper(TreeNode root, int k) {
        if (root == null) return;

        helper(root.left, k);
        count++;
        if (count == k) {
            res = root;
        }
        helper(root.right, k);

    }
}
