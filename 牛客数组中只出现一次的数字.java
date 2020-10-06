public class 牛客数组中只出现一次的数字 {
    public void FindNumsAppearOnce(int [] array, int num1[] , int num2[]) {
        int mask = 1;

        int temp = 0;

        for (int num: array) {
            temp ^= num;
        }

        while ((temp & mask) == 0) {
            mask <<= 1;
        }

        int x1 = 0, x2 = 0;

        for (int num: array) {
            if ((num & mask) == 0) {
                x1 ^= num;
            }else {
                x2 ^= num;
            }
        }

        num1[0] = x1;
        num2[0] = x2;
    }
}
