public class 数组中出现的次数2 {
    public int singleNumber(int[] nums) {
        // 除一个数字只出现一次之外，其他数字都出现了三次
        if (nums.length == 0) return 0;

        int[] bit = new int[32];

        for (int num: nums) {
            int mask = 1;
            for (int i = 31; i >= 0; i--) {
                if ((num & mask) != 0) bit[i]++;
                mask <<= 1;
            }
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += bit[i] % 3;
        }

        return res;
    }
}
