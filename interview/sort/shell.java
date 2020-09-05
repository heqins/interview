package interview.sort;

import java.util.Arrays;

public class shell {
    /**
     * 思路：希尔排序实质上就是插入排序的增强版，希尔排序将数组分隔成n组来进行插入排序，
     *直至该数组宏观上有序，**最后再进行插入排序时就不用移动那么多次位置了～
     */

    public static void shellSort(int[] arr) {
        // 增量每次都/2
        for (int step = arr.length / 2; step > 0; step /= 2) {
            // 从增量那组开始进行插入排序，直至完毕
            for (int i = step; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];

                // j - step就是代表与它同组隔壁的元素
                while (j - step >= 0 && arr[j - step] > temp) {
                    arr[j] = arr[j - step];
                    j = j -step;
                }

                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {2, -1, 3, 0, 4, -5};

        shellSort(test);

        System.out.println(Arrays.toString(test));
    }
}
