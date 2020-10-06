public class 礼物的最大价值 {
    public int maxValue(int[][] grid) {
        if (grid.length == 0) return 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                }else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                }else {
                    grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }

        int m = grid.length, n = grid[0].length;
        return grid[m - 1][n - 1];
    }
}
