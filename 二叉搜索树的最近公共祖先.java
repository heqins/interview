public class 二叉搜索树的最近公共祖先 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            }else if (root.val > p.val && root.val > q.val){
                root = root.left;
            }else {
                break;
            }
        }

        return root;
    }
}
