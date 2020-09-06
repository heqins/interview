package interview;

public class findKthLargest {
    public static int findKthLarge(int[] nums, int k) {
        if (nums.length == 0) return -1;

        k = nums.length - k;

        sort(nums, 0, nums.length - 1, k);

        return nums[k];
    }

    /**
     * public static void sort(int a[], int low, int hight, int k) {
     *         int i, j, index;
     *         if (low > hight) {
     *             return;
     *         }
     *         i = low;
     *         j = hight;
     *         index = a[i]; // 用子表的第一个记录做基准
     *         while (i < j) { // 从表的两端交替向中间扫描
     *             while (a[j] >= index)
     *                 j--;
     *             if (i < j)
     *                 a[i++] = a[j];// 用比基准小的记录替换低位记录
     *             while (i < j && a[i] < index)
     *                 i++;
     *             if (i < j) // 用比基准大的记录替换高位记录
     *                 a[j--] = a[i];
     *         }
     *         a[i] = index;// 将基准数值替换回 a[i]
     *         if (i == k) {
     *             return;
     *         }else if (i > k) {
     *             sort(a, low, i - 1, k); // 对低子表进行递归排序
     *         }else {
     *             sort(a, i + 1, hight, k); // 对高子表进行递归排序
     *         }
     *     }
     * @param nums
     * @param l
     * @param r
     * @param k
     */
    public static void sort(int[] nums, int l, int r, int k) {
        if (l > r) {
            return;
        }
        int i = l, j = r;
        int temp = nums[i];

        while (i < j) {
            while (i < j && nums[j] >= temp) j--;
            if (i < j) {
                nums[i++] = nums[j];
            }

            while (i < j && nums[i] < temp) i++;
            if (i < j) {
                nums[j--] = nums[i];
            }
        }

        nums[i] = temp;

        if (i == k) {
            return;
        }else if (i < k) {
            sort(nums, i + 1, r, k);
        }else {
            sort(nums, l, i - 1, k);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLarge(arr,  2));
    }
}
