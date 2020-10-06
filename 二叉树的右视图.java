import java.util.*;

public class 二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, TreeNode> map = new HashMap<>();

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        q1.offer(root);
        q2.offer(0);

        while (!q1.isEmpty()) {
            TreeNode cur = q1.poll();
            int depth = q2.poll();

            if (cur != null) {
                // 主要想法就是最右边的节点会在map中覆盖同层左边的节点
                map.put(depth, cur);

                q1.offer(cur.left);
                q1.offer(cur.right);

                q2.offer(depth + 1);
                q2.offer(depth + 1);
            }
        }

        int size = map.size();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            res.add(map.get(i).val);
        }

        return res;
    }
}
