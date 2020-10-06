import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 牛客判断一棵二叉树是否为搜索二叉树和完全二叉树 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    boolean[] res = new boolean[]{true, true};

    public boolean[] judgeIt (TreeNode root) {
        // write code here
        if (root == null) return res;

        helper1(root);
        helper2(root);

        return res;
    }

    public void helper1(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;

        int pre = Integer.MIN_VALUE;

        while (!s.isEmpty() || cur != null) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }

            cur = s.pop();
            if (pre >= cur.val) {
                res[0] = false;
                break;
            }

            pre = cur.val;

            if (cur.right != null) {
                cur = cur.right;
            }

        }
    }

    public void helper2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (null == cur.left) {
                // 遍历每个节点
                if (null != cur.right) {
                    res[1] = false;
                    break;
                }
                while (!queue.isEmpty()) {
                    TreeNode p = queue.poll();
                    if (null != p.left || null != p.right) {
                        res[1] = false;
                        break;
                    }
                }
                break;
            } else queue.add(cur.left);
            if (null == cur.right) {
                while (!queue.isEmpty()) {
                    TreeNode p = queue.poll();
                    if (null != p.left || null != p.right) {
                        res[1] = false;
                        break;
                    }
                }
                break;
            } else queue.add(cur.right);
        }
    }
}
