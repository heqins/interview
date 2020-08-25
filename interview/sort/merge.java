package interview.sort;

import java.util.Arrays;

public class merge {
    public static void main(String[] args) {
        int[] test = {1,4,-2,43,0,2,4,4};
        merge i = new merge();
        i.merge_sort(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));
    }

    /**
     * 归并排序的思想是将数组分成两部分，分别进行排序，然后归并起来。
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

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
