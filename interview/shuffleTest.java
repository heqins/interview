package interview;

import java.util.Arrays;
import java.util.Random;

public class shuffleTest {
    public void shuffle(int[] nums) {
        for (int i = nums.length - 1;i > 0; i--) {
            Random random = new Random();
            int randIndex = random.nextInt(i);
            swap(nums, i, randIndex);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5};
        shuffleTest st = new shuffleTest();
        st.shuffle(nums);
        System.out.println(Arrays.toString(nums));
    }
}
