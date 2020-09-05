package interview.sort;

public class getKLeast {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0) {
                return new int[0];
            } else if (arr.length <= k) {
                return arr;
            }

            // 原地不断划分数组
//            partitionArray(arr, 0, arr.length - 1, k);
            sort(arr, 0, arr.length - 1, k);

            // 数组的前 k 个数此时就是最小的 k 个数，将其存入结果
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = arr[i];
            }
            return res;
        }

    public static void sort(int a[], int low, int hight, int k) {
        int i, j, index;
        if (low > hight) {
            return;
        }
        i = low;
        j = hight;
        index = a[i]; // 用子表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描
            while (a[j] >= index)
                j--;
            if (i < j)
                a[i++] = a[j];// 用比基准小的记录替换低位记录
            while (i < j && a[i] < index)
                i++;
            if (i < j) // 用比基准大的记录替换高位记录
                a[j--] = a[i];
        }
        a[i] = index;// 将基准数值替换回 a[i]
        if (i == k) {
            return;
        }else if (i > k) {
            sort(a, low, i - 1, k); // 对低子表进行递归排序
        }else {
            sort(a, i + 1, hight, k); // 对高子表进行递归排序
        }
    }

    public static void main(String[] args) {

    }
}
