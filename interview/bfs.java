package interview;

import java.util.ArrayList;
import java.util.List;

public class bfs {
    public List<List<TreeNode>> traversal(TreeNode root) {
        if (root == null) return null;
        List<List<TreeNode>> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }

    private void dfs(TreeNode root, int level, List<List<TreeNode>> list) {
        if (root == null) return;
        if (level >= list.size()) {
            List<TreeNode> subList = new ArrayList<>();
            subList.add(root);
            list.add(subList);
        } else {
            list.get(level).add(root);
        }
        dfs(root.left, level+1, list);
        dfs(root.right, level+1, list);
    }
}
