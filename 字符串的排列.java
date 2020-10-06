import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 字符串的排列 {
    private static List<String> list = new ArrayList<>();
    public static String[] permutation(String s) {
        char[] cs = s.toCharArray();

        dfs(cs, 0);

        return list.toArray(new String[list.size()]);
    }

    public static void dfs(char[] cs, int x) {
        if (x == cs.length - 1) {
            list.add(String.valueOf(cs));
        }else {
            Set<Character> set = new HashSet<>();
            for (int i = x; i < cs.length; i++) {
                if (set.contains(cs[i])) continue;
                set.add(cs[i]);
                swap(cs, x, i);
                dfs(cs, x + 1);
                swap(cs, x, i);
            }
        }
    }

    public static void swap(char[] cs, int x, int i) {
        char temp = cs[x];
        cs[x] = cs[i];
        cs[i] = temp;
    }

    public static void main(String[] args) {
        permutation("abc");
    }
}
