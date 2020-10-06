import java.util.*;

public class 牛客LRU {
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public static int[] LRU (int[][] operators, int k) {
        // write code here
        LinkedHashMap<Integer,Integer> lruMap = new LinkedHashMap<Integer,Integer>();
        ArrayList<Integer> result = new ArrayList<>();

        /**
         * 若opt=1，接下来两个整数x, y，表示set(x, y)
         * 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
         * 对于每个操作2，输出一个答案
         */

        for(int[] opat:operators){
            int key = opat[1];
            switch(opat[0]){
                case 1:
                    int value = opat[2];
                    if(lruMap.size()<k){
                        lruMap.put(key,value);
                    }else{
                        /**
                         * 上述打印的时候，尽量从keySet()得到Iterator进行取值。
                         * 可以看出LinkedHashMap.keySet()拿到的Set是按照顺序的，其余三个都是乱序。
                         * 因此，当遇到对数据排序有严格要求的问题时，要用LinkedHashMap。
                         */
                        Iterator ot = lruMap.keySet().iterator();
                        lruMap.remove(ot.next());
                        lruMap.put(key,value);
                    }
                    break;
                case 2:
                    if(lruMap.containsKey(key)){
                        int val = lruMap.get(key);
                        result.add(val);
                        lruMap.remove(key);
                        lruMap.put(key,val);
                    }else{
                        result.add(-1);
                    }
                    break;
                default:
            }
        }
        int[] resultArr = new int[result.size()];
        int i = 0;
        for(int a: result){
            resultArr[i++]=a;
        }
        return resultArr;
    }

    public static void main(String[] args) {
        int[][] test = {{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
        int k = 3;
        LRU(test, k);

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(10, 10);
        map.put(1, 1);
        map.put(2, 2);

        Iterator it = map.keySet().iterator();

        map.get(10);
        map.remove(10);

        map.put(10, 10);

        System.out.println(it.next());
    }
}