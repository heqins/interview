public class 牛客二进制中1的个数 {
    public int NumberOf1(int n) {
        int mask = 1;
        int count = 0;

        while (n != 0) {
            if ((mask & n) == 1) {
                count++;
            }

            n >>>= 1;
        }

        return count;
    }
}
