package interview.sort;

import java.util.Arrays;

public class bubble {
    public static void main(String[] args) {
        int[] test = {1,4,-2,43,0,2,4,4};
        bubble i = new bubble();
        i.bubble_sort(test);
        System.out.println(Arrays.toString(test));
    }

    /**
     * 从左到右不断交换相邻逆序的元素，在一轮的循环之后，可以让未排序的最大元素上浮到右侧。
     * 在一轮循环中，如果没有发生交换，那么说明数组已经是有序的，此时可以直接退出。
     * @param nums
     */
    public void bubble_sort(int[] nums) {
        int n = nums.length;

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
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
