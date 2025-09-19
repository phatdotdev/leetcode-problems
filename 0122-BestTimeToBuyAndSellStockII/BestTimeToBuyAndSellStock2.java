public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int profit = 0, minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (minPrice > price) {
                minPrice = price;
            } else {
                profit += (price - minPrice);
                minPrice = price;
            }
        }
        return profit;
    }
}

/*
 * public int maxProfit(int[] prices) {
 * int n = prices.length, profit = 0;
 * int left = 0, right = 0;
 * while (left < n && right < n) {
 * while (left < n - 1 && prices[left] > prices[left + 1]) {
 * left++;
 * }
 * right = left;
 * while (right < n - 1 && prices[right] < prices[right + 1]) {
 * right++;
 * }
 * profit = profit + prices[right] - prices[left];
 * left = right + 1;
 * }
 * 
 * return profit;
 * }
 */