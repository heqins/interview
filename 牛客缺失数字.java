public class 牛客缺失数字 {
    public int solve (int[] a) {
        // write code here
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }

        int n = a.length;

        int total = (n * (n + 1)) / 2;

        return total - sum;
    }
}
