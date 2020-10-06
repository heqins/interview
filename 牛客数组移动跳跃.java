import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 牛客数组移动跳跃 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len = str.length();
        String[] strs = str.substring(1, len - 1).split(",");

        int[] arr = new int[strs.length];

        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }

        helper(arr);
    }

    public static void helper(int[] arr) {
        if (arr == null || arr.length == 0) System.out.println("false");
        Set<Integer> set = new HashSet<>();

        int index = 0;
        set.add(index);

        while (index < arr.length && index >= 0) {
            index += arr[index];

            if (!set.contains(index)) {
                set.add(index);
            }else {
                System.out.println("false");
                return;
            }
        }

        System.out.println("true");
    }
}
