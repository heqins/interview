public class 牛客买卖股票的最好时机 {
    public int maxProfit (int[] prices) {
        // write code here

        if (prices.length == 0 || prices.length == 1) return 0;

        int min = prices[0];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }

        return max;
    }
}
