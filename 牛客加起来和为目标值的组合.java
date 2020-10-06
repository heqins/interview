import java.util.ArrayList;
import java.util.Arrays;

public class 牛客加起来和为目标值的组合 {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        Arrays.sort(num);

        dfs(list, new ArrayList<Integer>(), num, target, 0);

        return list;
    }

    public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tempList, int[] num, int target, int start) {
        if (target == 0){
            if (!res.contains(tempList)) {
                res.add(new ArrayList(tempList));
                return;
            }
        }else if (target > 0) {
            for (int i = start; i < num.length; i++) {
                tempList.add(num[i]);
                dfs(res, tempList, num, target - num[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }else {
            return;
        }
    }
}
