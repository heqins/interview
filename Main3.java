import java.util.HashMap;
import java.util.Map;

import java.util.Scanner;
import java.util.*;
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] prices = new int[n];
            for (int i = 0; i < n; i++){
                prices[i] = sc.nextInt();
            }
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < m; i++){
                String temp = sc.nextLine();
                sc.nextLine();
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }

            List<Integer> num = new ArrayList<>(map.values());

            Collections.sort(num);

            int len = num.size();
            int len2 = prices.length;
            Arrays.sort(prices);
            int min = 0, max = 0;
            for (int i = 0; i < len; i++){
                max += prices[len2 - 1 - i] * num.get(i);
            }

            for (int i = 0; i < len; i++) {
                min += prices[i]* num.get(i);
            }

            System.out.println(min + " " + max);
        }
    }
}
