package interview.sort;

import java.util.Arrays;

public class quick {
    public static void quickSort(int[] arr, int l, int r) {
        int i = l;
        int j = r;

        int index = arr[i]; // 用子表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描
            while (i < j && arr[j] >= index)
                j--;
            if (i < j)
                arr[i++] = arr[j];// 用比基准小的记录替换低位记录
            while (i < j && arr[i] < index)
                i++;
            if (i < j) // 用比基准大的记录替换高位记录
                arr[j--] = arr[i];
        }
        arr[i] = index;// 将基准数值替换回 a[i]
        quickSort(arr, l, i - 1); // 对低子表进行递归排序
        quickSort(arr, i + 1, r); // 对高子表进行递归排序
    }

    public static void quickSort2(int[] arr) {
        // 做一次 partition 操作
        partitionArray2(arr, 0, arr.length - 1);
    }

    public static void partitionArray2(int[] arr, int lo, int hi) {
        int temp = arr[0];

        // 做一次 partition 操作
        int m = partition2(arr, lo, hi);

        arr[m] = temp;

        partitionArray2(arr, lo, m-1);
        partitionArray2(arr, m+1, hi);
    }

    public static int partition2(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {
            while (a[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (a[--j] > v) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, lo, j);

        // a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {-1,23, 4, 0, 24};
//        quickSort(arr, 0, arr.length - 1);
        partitionArray2(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
