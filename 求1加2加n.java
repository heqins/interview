public class 求1加2加n {
    int sum = 0;
    public static int sumNums(int n) {
        boolean flag = (n > 1) && (n += sumNums(n - 1)) > 1;

        return n;
    }

    public static void main(String[] args) {
        System.out.println(sumNums(3));
    }
}
