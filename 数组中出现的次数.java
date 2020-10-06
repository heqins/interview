public class 数组中出现的次数 {
    public static int[] singleNumbers(int[] nums) {
        // 除两个数字之外，其他数字都出现了两次
        int mask = 1;
        int res = 0;

        if (nums.length == 0) {
            return new int[0];
        }

        for (int num: nums) {
            res ^= num;
        }

        while ((mask & res) == 0) {
            mask <<= 1;
        }

        int a = 0, b = 0;

        for (int num: nums) {
            // 只能是==0
            if ((mask & num) == 0) {
                a ^= num;
            }else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }

    public static void main(String[] args) {
        singleNumbers(new int[]{2,4,3,6,3,2,5,5});
        System.out.println(2 & 6);
    }
}
