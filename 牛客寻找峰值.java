public class 牛客寻找峰值 {
    public int solve (int[] a) {
        // write code here
        if (a == null || a.length == 0) return -1;

        for (int i = a.length - 1; i >= 1; i--) {
            if (a[i] >= a[i - 1]) {
                return i;
            }
        }

        return 0;
    }
}
