import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class 完美字符串 {
    // 8 1
    // aabaabaa -> 5 最长完美字符串aaaaa
    public static void main(String[] args) {
        int n = 8;
        int m = 1;

        String str = "aabaabaa";
        int res = 0;

        for (char i = 'a'; i <= 'z'; i++) {
            int used  = 0;
            int left = 0;
            for (int right = left; right < n; right++) {
                if (str.charAt(right) != i) {
                    used++;
                }

                while (used > m){
                    if (str.charAt(left++) != i) {
                        used--;
                    }
                }
                res = Math.max(res, right - left + 1);
            }
        }

        System.out.println(res);
    }

}
