import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 把数组排成最小的数 {
    public String minNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();

        List<String> list = new ArrayList<>();

        for (int num: nums) {
            list.add(String.valueOf(num));
        }

        list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));

        for (String s : list) {
            sb.append(s);
        }

        return sb.toString();
    }
}
