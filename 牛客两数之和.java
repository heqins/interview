import java.util.HashMap;
import java.util.Map;

public class 牛客两数之和 {
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                return new int[]{map.get(numbers[i]) + 1, i + 1};
            }

            map.put(target - numbers[i], i);
        }

        return null;
    }
}
