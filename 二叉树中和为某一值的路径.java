import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树中和为某一值的路径 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        dfs(res, new Stack<>(), root, sum);

        return res;
    }

    public void dfs(List<List<Integer>> res, Stack<Integer> s, TreeNode cur, int sum){
        s.push(cur.val);
        if (cur.left == null && cur.right == null){
            if (sum == cur.val) {
                res.add(new ArrayList<>(s));
            }
        }
        if (cur.left != null) dfs(res, s, cur.left, sum - cur.val);
        if (cur.right != null) dfs(res, s, cur.right, sum - cur.val);
        s.pop();
    }
}
