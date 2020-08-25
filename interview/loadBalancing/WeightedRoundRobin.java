package interview.loadBalancing;

import java.util.*;

public class WeightedRoundRobin {
    private static Integer pos = 0;

    /**
     * 与轮询法类似，只是在获取服务器地址之前增加了一段权重计算的代码，根据权重的大小，
     *
     * 将地址重复地增加到服务器地址列表中，权重越大，该服务器每轮所获得的请求数量越多。
     * @return
     */
    public static String getServer()
    {
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap =
                new HashMap<String, Integer>();
        serverMap.putAll(IpMap.serverWeightMap);

        // 取得Ip地址List
        Set<String> keySet = serverMap.keySet();
        Iterator<String> iterator = keySet.iterator();

        List<String> serverList = new ArrayList<String>();
        while (iterator.hasNext())
        {
            String server = iterator.next();
            int weight = serverMap.get(server);
            for (int i = 0; i < weight; i++)
                serverList.add(server);
        }

        String server = null;
        synchronized (pos)
        {
            if (pos > keySet.size())
                pos = 0;
            server = serverList.get(pos);
            pos ++;
        }

        return server;
    }

    public static void main(String[] args) {
        System.out.println(getServer());
        System.out.println(getServer());
        System.out.println(getServer());
        System.out.println(getServer());
        System.out.println(getServer());
    }
}
