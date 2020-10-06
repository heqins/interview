public class 二叉搜索树的后序遍历序列 {
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    public boolean helper(int[] postorder, int left, int right) {
        if (left >= right) return true;

        int i = left;

        while (postorder[i] < postorder[right]) {
            i++;
        }

        while (postorder[i] > postorder[right]) {
            i++;
        }

        // 为什么还要再递归划分判断区间？
        return (i == right) && (helper(postorder, left, i - 1) && helper(postorder, i + 1, right));
    }
}
