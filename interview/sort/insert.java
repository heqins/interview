package interview.sort;

import java.util.Arrays;

public class insert {
    public static void main(String[] args) {
        int[] test = {1,4,-2,43,0,2,4,4};
        insert i = new insert();
        i.insert_sort(test);
        System.out.println(Arrays.toString(test));
    }

    public void insert_sort(int[] nums) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }else {
                    break;
                }
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
