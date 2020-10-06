public class 牛客N皇后 {
    // 找到的方案数
    private int res;

    public int Nqueen(int n) {
        // write code here
        res = 0;
        dfs(new int[n], 0);
        return res;
    }

    /**
     * nums: 每一行放在哪个位置，如nums[0] = 4，表示第0行的皇后放在第4列（把行列互换来理解也一样）
     * cur: 当前已经放了几行
     */
    public void dfs(int[] nums, int cur) {
        int n = nums.length;
        // cur == n 表示每一行都已经放了皇后，说明找到了一种方案
        if (cur == n) {
            res++;
            return;
        }

        // 找到可访问的位置
        boolean[] visited = new boolean[n];
        // 遍历之前的每一行（均已放置皇后），把当前行中所有会和之前的皇后冲突的位置都排除掉
        // i表示判断到第几行，易知第i行的皇后在(i, nums[i])上
        for (int i = 0; i < cur; i++) {
            // e表示第i行到当前行的距离，要根据这个距离来判断斜向冲突的位置
            int e = cur - i;
            // v表示第i行的皇后放在哪一列，这一列需要被排除掉（visited[v] = true;）
            int v = nums[i];
            // r表示右下方向发生冲突的列, l表示左下方向发生冲突的列
            // 比如num[0] = 3, cur = 2这就说明第0行的皇后放在(0,3)
            // 那么在当前行也就是第2行，(2, 1)和(2, 5)就与(0,3)在同一斜向
            // 即r = v + e = num[0] + (cur-i) = 3 + (2-0) = 5
            // l = v - e = num[0] - (cur-i) = 3 - （2-0）= 1
            int r = v + e;
            int l = v - e;
            visited[v] = true;
            if (l >= 0) visited[l] = true;
            if (r < n) visited[r] = true;
        }

        // 对当前行剩余所有可放皇后的位置，进行递归
        for (int i = 0; i < n; i++) {
            // visited[i]表示当前行的第i列和已放的皇后冲突，跳过
            if (visited[i]) continue;
            nums[cur] = i;
            dfs(nums, cur + 1);
        }
    }
}
