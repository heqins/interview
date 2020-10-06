import java.util.LinkedList;

public class 牛客岛屿数量 {
    int count = 0;
    public int solve (char[][] grid) {
        // write code here
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j, m, n);
                    ++count;
                }
            }
        }

        return count;
    }

    public void bfs(char[][] grid,int i,int j,int row,int col){
        LinkedList<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{i,j});
        while(queue.size()>0){
            int[] temp=queue.poll();
            i=temp[0];
            j=temp[1];
            if(i>=0&&i<row&&j>=0&&j<col&&grid[i][j]=='1'){
                grid[i][j]='0';
                queue.offer(new int[]{i-1,j});
                queue.offer(new int[]{i+1,j});
                queue.offer(new int[]{i,j-1});
                queue.offer(new int[]{i,j+1});
            }
        }
    }
}
