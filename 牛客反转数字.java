public class 牛客反转数字 {
    public int reverse (int x) {
        // write code here
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder();

        boolean sign = false;

        int i = 0;
        if (str.charAt(0) == '-') {
            sign = true;
            i++;
        }

        for (int j = str.length() - 1; j >= i; j--) {
            sb.append(str.charAt(j));
        }

        return sign ? -Integer.parseInt(sb.toString()) : Integer.parseInt(sb.toString());
    }
}
