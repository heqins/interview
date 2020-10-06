import java.util.ArrayList;

public class 牛客有重复数字的所有排列 {
    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        boolean[] used = new boolean[num.length];

        dfs(res, num, new ArrayList<Integer>(), used, 0);

        return res;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> res, int[] num, ArrayList<Integer> tempList, boolean[] used, int start) {
        if (tempList.size() == num.length) {
            if (!res.contains(tempList)) {
                res.add(new ArrayList<>(tempList));
            }
        }else {
            for (int i = 0; i < num.length; i++) {
                if (used[i]) continue;
                tempList.add(num[i]);
                used[i] = true;
                dfs(res, num, tempList, used,start + 1);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args) {
        permuteUnique(new int[]{1, 1, 2});
    }
}
