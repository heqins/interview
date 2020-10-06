public class 牛客二叉树根节点到叶节点的所有路径和 {
    private int res = 0;
    public int sumNumbers (TreeNode root) {
        // write code here
        if (root == null) return res;

        dfs(root, 0);

        return res;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) return;

        sum = sum * 10 + root.val;

        if (root.left == null && root.right == null) {
            res += sum;
            return;
        }

        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}
