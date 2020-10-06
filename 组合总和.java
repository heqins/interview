import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 组合总和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Set<List<Integer>> set = new HashSet<List<Integer>>();

        dfs(candidates, target, set, new ArrayList<Integer>(), 0);

        res.addAll(set);

        return res;
    }

    public void dfs(int[] candidates, int target, Set<List<Integer>> set, List<Integer> tempList, int start) {
        if (target == 0) {
            set.add(tempList);
        }else {
            // target < 0时，剪枝
            if (target > 0) {
                for (int i = start; i < candidates.length; i++) {
                    tempList.add(candidates[i]);
                    dfs(candidates, target - candidates[i], set, tempList, i);
                    tempList.remove(tempList.size() - 1);
                }
            }else {
                return;
            }
        }
    }
}
