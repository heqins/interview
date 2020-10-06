import java.util.ArrayList;
import java.util.List;

public class 全排列 {
    boolean[] isUsed;
    public List<List<Integer>> permute(int[] nums) {
        // 给定一个 没有重复 数字的序列，返回其所有可能的全排列，[1,2,3]
        List<List<Integer>> res = new ArrayList<>();
        isUsed = new boolean[nums.length];

        if (nums.length == 0) return res;

        dfs(nums, res, new ArrayList<>());

        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> temp) {
        if (temp.size() == nums.length) {
            res.add(temp);
        }else {
            for (int i = 0; i < nums.length; i++){
                if (!isUsed[i]) {
                    isUsed[i] = true;
                    temp.add(nums[i]);
                    dfs(nums, res, temp);
                    temp.remove(temp.size() - 1);
                    isUsed[i] = false;
                }
            }
        }
    }
}
