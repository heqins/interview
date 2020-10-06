public class 牛客环形链表的约瑟夫环问题 {
    public int ysf (int n, int m) {
        // write code here
        int pos = 0; // 最终活下来那个人的初始位置
        for(int i = 2; i <= n; i++){
            pos = (pos + m) % i;  // 每次循环右移
        }
        return pos - 1;
    }
}
