import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 最长不含重复字符的子字符串 {
    public int lengthOfLongestSubstring(String s) {
        // "abcabcbb"，因为无重复字符的最长子串是 "abc"，所以其长度为 3
        if (s == null || s.length() == 0) {
            return 0;
        }

        int left = -1;

        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)));
            }
            map.put(s.charAt(i), i);
            // 当i = 0时，left为0则长度为0
            maxLen = Math.max(maxLen, i - left);
        }

        return maxLen;
    }
}
