import java.util.*;


public class 牛客找到字符串的最长无重复字串的长度 {
    /**
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {
        // [2,2,3,4,3], 3

        // write code here
        int len = arr.length;

        if (len == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        //n当前子串长度，max最大值
        int n = 0, max = 0;
        //记录目前子串的起点
        int left = 0;
        for(int i=0; i<arr.length; i++){
            //如果与当前子串有重复（map.get(arr[i]) >= left 用来保证是在当前子串内进行判重）
            if(map.containsKey(arr[i]) && map.get(arr[i]) >= left){
                //重置当前子串长度
                n = n - (map.get(arr[i]) - left);
                //重置当前子串起点
                left = map.get(arr[i])+1;
            }
            else n++;//不重复则当前子串长度+1

            //更新最大值
            max = Math.max(max, n);
            //记录结点值与下标
            map.put(arr[i], i);
        }
        //返回最大长度
        return max;
    }
}