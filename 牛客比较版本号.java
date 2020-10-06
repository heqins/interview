public class 牛客比较版本号 {
    /**
     * 比较版本号
     * @param version1 string字符串
     * @param version2 string字符串
     * @return int整型
     */
    public int compare (String version1, String version2) {
        // write code here
        int len1 = version1.length();
        int len2 = version2.length();

        int i1 = 0, i2 = 0;
        int num1 = 0, num2 = 0;

        while (i1 < len1 && i2 < len2) {
            char c1 = version1.charAt(i1);
            char c2 = version2.charAt(i2);

            if (c1 != '.') num1 = num1 * 10 + (c1 - '0');
            if (c2 != '.') num2 = num2 * 10 + (c2 - '0');

            if (c1 == '.' && c2 == '.') {
                if (num1 > num2) return 1;
                else if (num1 < num2) return -1;
                num1 = 0;
                num2 = 0;
            }

            if (c1 != '.' && c2 == '.') i1++;
            else if (c1 == '.' && c2 != '.') i2++;
            else {
                i1++;
                i2++;
            }
        }

        if (i1 < len1) return 1;
        if (i2 < len2) return -1;
        return 0;
    }
}
