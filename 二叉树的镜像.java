public class 二叉树的镜像 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;

        TreeNode left = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(left);

        return root;
    }
}
