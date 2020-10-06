public class 把字符串转换成数字 {
    public int strToInt(String str) {
        char[] cs = str.trim().toCharArray();
        if (cs.length == 0) return 0;
        int sign = 1;
        int i = 1;
        if (cs[0] == '-') {
            sign = -1;
        }else if (cs[0] != '+') {
            i=0;
        }
        int res = 0;
        for (;i < cs.length; i++) {
            if ((cs[i] - '0') > 9 || (cs[i] - '0') < 0) {
                break;
            }

            if (res > (int)Math.pow(2, 31) / 10 || (res == (int)Math.pow(2, 31) / 10 && cs[i] - '0' > 7)) {
                return sign == 1 ? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }

            res = res * 10 + cs[i] - '0';
        }

        return sign == 1 ? res : -res;
    }
}
