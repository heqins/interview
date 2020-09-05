package interview.sort;

public class radixSort {
    public static void radixSort(int[] arrays) {
        int max = findMax(arrays, 0, arrays.length - 1);

        // 需要遍历的次数由数组最大值的位数来决定
        for (int i = 1; max / i > 0; i = i * 10) {
            int[][] buckets= new int[arrays.length][10];

            // 获取每一位数字
            for (int j = 0; j < arrays.length; j++) {
                int num = (arrays[j] / i) % 10;
                // 将其放入桶内
                buckets[j][num] = arrays[j];
            }

            // 回收桶内的元素
            int k = 0;

            // 有10个桶子
            for (int j = 0; j < 10; j++) {
                // 对每个桶内的元素进行回收
                for (int l = 0; l < arrays.length; l++) {
                    // 如果桶内有元素就进行回收（数据初始化为0）
                    if (buckets[l][j] != 0) {
                        arrays[k++] = buckets[l][j];
                    }
                }
            }
        }
    }

    public static int findMax(int[] arrays, int L, int R) {
        // 如果该数组只有一个数，那么最大的就是该数组第一个值了
        if (L == R) {
            return arrays[L];
        }else {
            int a = arrays[L];
            int b = findMax(arrays, L + 1, R); // 找出整体的最大值

            if (a > b) {
                return a;
            }else {
                return b;
            }
        }
    }
}
