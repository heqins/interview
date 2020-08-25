package interview.sort;

import java.util.Arrays;

public class select {
    public static void main(String[] args) {
        int[] test = {1,4,-2,43,0,2,4,4};
        select i = new select();
        i.select_sort(test);
        System.out.println(Arrays.toString(test));
    }

    /**
     * 从数组中选择最小元素，将它与数组的第一个元素交换位置。再从数组剩下的元素中选择出最小的元素，
     * 将它与数组的第二个元素交换位置。不断进行这样的操作，直到将整个数组排序。
     * @param nums
     */
    public void select_sort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }

            swap(nums, i, min);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
