package interview.sort;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;

public class merge {
    public static void main(String[] args) {
        int[] test = {1,4,-2,43,0,2,4,4};
        merge i = new merge();
        i.merge_sort(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));
    }
    /**
     * 递归在算法里边用得非常非常多，排序算法的快速排序和归并排序就需要用到递归（至少用递归来实现是最方便的）。
     * 想要用递归必须知道两个条件：递归出口(终止递归的条件)和递归表达式(规律)
     * @param arrays
     */

    /**
     * 归并排序的思想是将数组分成两部分，分别进行排序，然后归并起来。
     * 思路：将两个已排好序的数组合并成一个有序的数组。将元素分隔开来，看成是有序的数组，进行比较合并。不断拆分和合并，直到只有一个元素
     * 代码实现：在第一趟排序时实质是两个元素(看成是两个已有序的数组)来进行合并，不断执行这样的操作，最终数组有序，拆分左边，右边，合并…
     * @param nums
     * @param left
     * @param right
     */
    public void merge_sort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;

        merge_sort(nums, left, mid);
        merge_sort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[nums.length];

        int l1 = left;
        int l2 = mid + 1;
        int newIndex = left;
        int newIndex2 = left;

        while (l1 <= mid && l2 <= right) {
            if (nums[l1] < nums[l2]) {
                temp[newIndex++] = nums[l1++];
            }else {
                temp[newIndex++] = nums[l2++];
            }
        }

        while (l1 <= mid) {
            temp[newIndex++] = nums[l1++];
        }

        while (l2 <= right) {
            temp[newIndex++] = nums[l2++];
        }

        while (newIndex2 <= right) {
            nums[newIndex2] = temp[newIndex2];
            newIndex2++;
        }
    }
}
