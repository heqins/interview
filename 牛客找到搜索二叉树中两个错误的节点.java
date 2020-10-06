public class 牛客找到搜索二叉树中两个错误的节点 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    int[] res = new int[2];
    boolean flag = false;
    TreeNode pre;
    public int[] findError (TreeNode root) {
        // write code here
        inorder(root);

        return res;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (pre != null && pre.val > root.val) {
            if (!flag) {
                res[1] = pre.val;
                flag = true;
            }

            res[0] = root.val;
        }

        pre = root;

        inorder(root.right);
    }
}
