import java.util.*;

public class 给定数字按字典序排序 {
    List<Integer> anslexicalOrder = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        lexicalOrderDFS(n, 0, 0);
        return anslexicalOrder;
    }

    public void lexicalOrderDFS(int maxValue, int num, int start) {
        if (num > maxValue) return;

        if (num > 0) anslexicalOrder.add(num);

        for (int i = start > 0 ? 0 : 1; i <= 9; i++) {
            lexicalOrderDFS(maxValue, num * 10 + i, start + 1);
        }
    }

}
