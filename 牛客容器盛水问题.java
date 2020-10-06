public class 牛客容器盛水问题 {
    public long maxWater (int[] arr) {
        // write code here
        // write code here
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = arr[0];
        right[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }
        for(int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }
        long res = 0;
        for (int i = 1; i < n - 1; i++) {
            res += Math.min(left[i], right[i]) - arr[i];
        }
        return res;
    }
}
