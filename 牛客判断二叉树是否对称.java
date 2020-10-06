import java.util.Stack;

public class 牛客判断二叉树是否对称 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSymmetric (TreeNode root) {
        // write code here
        // 非递归
        if (root == null) return true;

        Stack<TreeNode> s = new Stack<>();

        s.push(root.left);
        s.push(root.right);

        while(!s.isEmpty()) {
            TreeNode n1 = s.pop();
            TreeNode n2 = s.pop();

            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null || n1.val != n2.val) return false;

            s.push(n1.left);
            s.push(n2.right);
            s.push(n1.right);
            s.push(n2.left);
        }

        return true;
    }

    /** 递归
     * public boolean isSymmetric (TreeNode root) {
     *         // write code here
     *         if (root == null) return true;
     *
     *         return helper(root, root);
     *     }
     *
     *     public boolean helper(TreeNode A, TreeNode B) {
     *         if (A == null && B == null) return true;
     *
     *         if (A == null || B == null || A.val != B.val) return false;
     *
     *         return helper(A.left, B.right) && helper(A.right, B.left);
     *     }
     */
}
