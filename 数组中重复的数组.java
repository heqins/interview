import java.util.HashSet;
import java.util.Set;

public class 数组中重复的数组 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeat = -1;

        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
            }
        }

        return repeat;
    }
}
