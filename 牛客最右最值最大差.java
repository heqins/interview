public class 牛客最右最值最大差 {
    /**
     * 因为继续往左扩充，如果A[n-2] < A[n-1]，
     * 那么右边的最大值依然是A[n-1]，如果A[n-2] > A[n-1]，
     * 那么显然右侧只包含A[n-1]一个元素时，左部分中的最大值减去右部分最大值的绝对值最大，
     * 最值依然是A[n-1]）
     */

    public int findMaxGap(int[] A, int n) {
        // write code here
        int max = Integer.MIN_VALUE;
        for (int num: A) {
            max = Math.max(max, num);
        }

        return max - Math.min(A[0], A[n - 1]);
    }
}
