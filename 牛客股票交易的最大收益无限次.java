public class 牛客股票交易的最大收益无限次 {
    public int maxProfit (int[] prices) {
        // write code here

        /**
         * 遍历整个股票交易日价格列表 price，策略是所有上涨交易日都买卖（赚到所有利润），
         * 所有下降交易日都不买卖（永不亏钱）。
         */
        if (prices.length == 0 || prices.length == 1) return 0;

        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }

        return max;
    }
}
