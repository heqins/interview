public class 数组中出现次数超过一半的数字 {
    public int majorityElement(int[] nums) {
        int x = 0;
        int votes = 0;

        for (int num: nums) {
            if (votes == 0) x = num;

            votes += x == num ? 1 : -1;
        }

        return x;
    }
}
