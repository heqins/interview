import java.util.HashMap;
import java.util.Map;

public class 牛客数组中出现次数超过一半的数字 {
    public static int MoreThanHalfNum_Solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++){
            int temp = array[i];

            map.put(temp, map.getOrDefault(temp, 0) + 1);

            if (map.get(temp) > array.length / 2) {
                return temp;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] test = {1,2,3,2,4,2,5,2,3};
        MoreThanHalfNum_Solution(test);
    }
}
