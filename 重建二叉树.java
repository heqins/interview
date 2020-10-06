public class 重建二叉树 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);

        return root;
    }

    public TreeNode helper(int[] preorder, int[] inorder, int lp, int rp, int li, int ri) {
        if (lp > rp) return null;

        TreeNode root = new TreeNode(preorder[lp]);

        for (int i = li; i <= ri; i++){
            if (preorder[lp] == inorder[i]) {
                root.left = helper(preorder, inorder, lp + 1, lp + (i- li), li, i - 1);
                root.right = helper(preorder, inorder, lp + (i- li), rp, i + 1, ri);
            }
        }

        return root;
    }
}
