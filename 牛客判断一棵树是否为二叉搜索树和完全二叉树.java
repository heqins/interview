import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 牛客判断一棵树是否为二叉搜索树和完全二叉树 {
    boolean[] res = new boolean[]{true, true};
    TreeNode pre;

    public boolean[] judgeIt (TreeNode root) {
        // write code here
        if (root == null) return res;

        helper1(root);
        helper2(root);

        return res;
    }

    public void helper1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root, pre = null;
        //树的中序遍历非递归解法，需要额外使用一个pre指针记录前一节点
        while(node != null || !stack.isEmpty()){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                if(pre != null && pre.val > node.val){ //判断前一节点和当前节点的值大小关系
                    res[0] = false;
                    break;
                }
                pre = node;
                node = node.right;
            }
        }
    }

    public void helper2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                flag = true;
                continue;
            }

            if (flag) {
                res[1] = false;
                break;
            }

            queue.offer(cur.left);
            queue.offer(cur.right);
        }
    }
}
