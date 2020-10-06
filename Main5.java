import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] temp = sc.nextLine().split(" ");
            String num = temp[0];
            int l = Integer.parseInt(temp[1]);
            int r = Integer.parseInt(temp[2]);
            int sum = 0;
            for (int j = l; j <= r; j++) {
                sum += Integer.valueOf(num, j);
            }
            if (sum % 2 == 0) {
                System.out.println(0);
            }else {
                System.out.println(1);
            }
        }
    }
}
