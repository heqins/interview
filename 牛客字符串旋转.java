import java.util.Scanner;

public class 牛客字符串旋转 {
    public static boolean res = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(";");

        String a = strs[0];
        String b = strs[1];

        for (int i = 0; i < a.length(); i++) {
            a = a.substring(1) + a.charAt(0);
            if (a.equals(b)) {
                System.out.println("true");
                return;
            }
        }

        System.out.println("false");

    }
}
