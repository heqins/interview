import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合 {
    Map<String, String> map = new HashMap() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }

        dfs("", digits);

        return res;
    }

    public void dfs(String combinations, String nextDigits) {
        if (nextDigits.length() == 0) {
            res.add(combinations);
        }else {
            String digit = nextDigits.substring(0, 1);
            String letters = map.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                dfs(combinations + letter, nextDigits.substring(1));
            }
        }
    }
}
