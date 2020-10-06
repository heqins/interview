import java.util.ArrayList;
import java.util.Arrays;

/**
 * 46. Permutations
 * @author Jacob
 * 题意：求数组的全排列
 */
public class 牛客没有重复项数字的所有排列 {
    ArrayList<ArrayList<Integer>> res;

    public ArrayList<ArrayList<Integer>> permute(int[] nums) {
        res = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length < 1)
            return res;
        //对数组元素进行从小到大排序
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<Integer>();

        solve(list, nums);

        return res;
    }

    private void solve(ArrayList<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                solve(list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}