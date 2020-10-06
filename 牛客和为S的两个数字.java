import java.util.ArrayList;

public class 牛客和为S的两个数字 {
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();

        if (array.length == 0) return res;

        int min = Integer.MAX_VALUE;

        int left = 0;
        int right = array.length - 1;

        int index1 = -1;
        int index2 = -1;

        while (left < right) {
            int total = array[left] + array[right];

            if (total > sum) {
                right--;
            }else if (total < sum) {
                left++;
            }else {
                if (array[left] * array[right] < min) {
                    min = array[left] * array[right];
                    index1 = array[left];
                    index2 = array[right];
                }
                right--;
                left++;
            }
        }

        if (min != Integer.MAX_VALUE) {
            res.add(index1);
            res.add(index2);
        }

        return res;
    }

    public static void main(String[] args) {
        FindNumbersWithSum(new int[]{1, 2, 4, 7, 11, 15}, 15);
    }
}
