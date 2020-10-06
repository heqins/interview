public class 牛客斐波拉契数列 {
    public int Fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;

        int one = 1;
        int two = 1;

        int res = 0;

        for (int i = 2; i < n; i++) {
            res = one + two;
            one = two;
            two = res;
        }

        return res;
    }
}
