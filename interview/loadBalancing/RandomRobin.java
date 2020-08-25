package interview.loadBalancing;

import java.util.*;

public class RandomRobin {
    /**
     * 整体代码思路和轮询法一致，先重建serverMap，再获取到server列表。
     *
     * 在选取server的时候，通过Random的nextInt方法取0~keyList.size()区间的一个随机值，从而从服务器列表中随机获取到一台服务器地址进行返回。
     *
     * 基于概率统计的理论，吞吐量越大，随机算法的效果越接近于轮询算法的效果。
     * @return
     */

    public static String getServer() {
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap =
                new HashMap<String, Integer>();
        serverMap.putAll(IpMap.serverWeightMap);

        // 取得Ip地址List
        Set<String> keySet = serverMap.keySet();
        ArrayList<String> keyList = new ArrayList<String>();
        keyList.addAll(keySet);

        Random random = new Random();
        int randomPos = random.nextInt(keyList.size());

        return keyList.get(randomPos);
    }
}
