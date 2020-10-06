import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 序列化二叉树 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";

        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();
        sb.append("[");

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();

            if (cur == null) {
                sb.append("null,");
            }else {
                sb.append(cur.val + ",");
                q.add(cur.left);
                q.add(cur.right);
            }
        }

        sb.deleteCharAt(sb.length() - 1);

        sb.append("]");

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;

        String[] str = data.substring(1, data.length() - 1).split(",");

        TreeNode root = new TreeNode(Integer.parseInt(str[0]));

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        int i = 1;

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();

            if (!str[i].equals("null")) {
                TreeNode temp = new TreeNode(Integer.parseInt(str[i]));
                cur.left = temp;
                q.add(temp);
            }

            i++;

            if (!str[i].equals("null")) {
                TreeNode temp = new TreeNode(Integer.parseInt(str[i]));
                cur.right = temp;
                q.add(temp);
            }
            i++;
        }

        return root;
    }
}
