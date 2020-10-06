import java.util.Arrays;

public class 牛客反转字符串 {
    public static String solve (String str) {
        // write code here
        int n = str.length();

        int left = 0;
        int right = n - 1;

        char[] array = str.toCharArray();
        while (left < right) {
            swap(array, left, right);
            left++;
            right--;
        }

        return new String(array);
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(solve("abcd"));
    }
}
