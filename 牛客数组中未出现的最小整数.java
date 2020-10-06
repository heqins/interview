public class 牛客数组中未出现的最小整数 {
    public static int minNumberdisappered (int[] arr) {
        // write code here
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= arr.length && arr[arr[i] - 1] != arr[i]) {
                swap(arr, i, arr[i] - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        minNumberdisappered(new int[]{2, 4, 5, 6});
    }
}
