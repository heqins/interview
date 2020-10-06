public class 牛客寻找第K大 {
    public int findKth(int[] a, int n, int K) {
        // write code here
        K = n - K;

        sort(a, 0, n - 1, K);

        return a[K];
    }

    public void sort(int[] a, int left, int right, int K) {
        if (left > right) return ;

        int i = left;
        int j = right;
        // temp = a[i]不是a[0]
        int temp = a[i];

        while (i < j) {
            while (i < j && a[j] >= temp) j--;
            if (i < j) a[i++] = a[j];

            while (i < j && a[i] < temp) i++;
            if (i < j) a[j--] = a[i];
        }

        a[i] = temp;

        if (i == K) {
            return;
        }else if (i < K) {
            // 右边界是right，不是j
            sort(a, i + 1, right, K);
        }else {
            sort(a, left, j - 1, K);
        }
    }
}
