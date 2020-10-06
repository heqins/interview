public class 牛客矩阵元素查找 {
    public int[] findElement(int[][] mat, int n, int m, int x) {
        // write code here
        if (mat == null || mat.length == 0) return new int[0];
        int row = 0;
        int col = m - 1;
        int[] res = new int[2];
        while (row < n && col >= 0) {
            if (mat[row][col] < x) {
                row++;
            }else if (mat[row][col] > x){
                col--;
            }else {
                res[0] = row;
                res[1] = col;
                break;
            }
        }

        return res;
    }
}
