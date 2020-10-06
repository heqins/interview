public class 反转字符串里的单词 {
    public String reverseWords(String s) {
        /**
         * public String reverseWords(String s) {
         *         s = s.trim(); // 删除首尾空格
         *         int j = s.length() - 1, i = j;
         *         StringBuilder res = new StringBuilder();
         *         while(i >= 0) {
         *             while(i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
         *             res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
         *             while(i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
         *             j = i; // j 指向下个单词的尾字符
         *         }
         *         return res.toString().trim(); // 转化为字符串并返回
         *     }
         *
         * 作者：jyd
         * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string/solution/151-fan-zhuan-zi-fu-chuan-li-de-dan-ci-shuang-zh-2/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */

        StringBuilder sb = new StringBuilder();

        String[] strs = s.trim().split(" ");
        int n = strs.length;

        for (int i = n - 1; i >= 0; i--) {
            if (strs[i].equals("")) {
                continue;
            }
            sb.append(strs[i] + " ");
        }

        return sb.toString().trim();
    }
}
