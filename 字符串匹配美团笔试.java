import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 字符串匹配美团笔试 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s1 = sc.nextLine().split(" ");

        Integer n = Integer.parseInt(s1[0]);
        Integer m = Integer.parseInt(s1[1]);

        String s = sc.nextLine();
        String p = sc.nextLine();

        int res = 0;

        res = helper(s, p);

        if (res == 0) {
            System.out.println("NO");
        }else {
            System.out.println("YES");
        }
        System.out.println(res);
    }

    public static int helper(String source, String target) {
        Map<Character, Integer> map = new HashMap<>();

        // s: aabddc, p: abc
        int i = 0, j = 0, k;
        int sum = 0;
        while(j < target.length())
        {
            k = j;//记录开始的地方
            i = 0;//新的开始
            while(i < source.length())//遍历字符串
            {
                if(source.charAt(i) == target.charAt(j))//可以给到target
                {
                    if (map.containsKey(source.charAt(i))) {
                        continue;
                    }

                    sum += (i + 1);

                    map.put(source.charAt(i), i);

                    i++;
                    j++;
                }
                else
                    i++;//删除某字符
            }
            if(j == k)//没有填入一个字符到target
                return -1;
        }
        return sum;
    }
}
