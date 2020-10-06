import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 牛客二叉树的之字形层序遍历 {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> res =  new ArrayList<ArrayList<Integer>>();

        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        int height = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                tempList.add(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }

                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }

            if (height % 2 !=0) Collections.reverse(tempList);
            height++;

            res.add(tempList);
        }

        return res;
    }
}
