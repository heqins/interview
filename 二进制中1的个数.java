public class 二进制中1的个数 {
    public int hammingWeight(int n) {
        int bitMask = 1;

        int count = 0;

        while (n != 0) {
            if ((bitMask & n) == 1) {
                count++;
            }

            // 要求看成是无符号数
            // n & n - 1消去最右边的1
            n >>>= 1;
        }

        return count;
    }
}
