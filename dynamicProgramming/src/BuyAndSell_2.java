import java.util.Arrays;

public class BuyAndSell_2 {
    /*
    You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock
at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.
     */
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2)
            return 0;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        boolean having = false;
        return helper(0,prices,dp,having);
    }

    private static int helper(int i, int[] prices, int[] dp, boolean having) {
        if(i >= prices.length || (i>= prices.length-1 && !having))
            return 0;
        if(dp[i] != -1)
            return dp[i];
        if(having){
            int x = prices[i]+helper(i+1,prices,dp,!having);
            int y = helper(i+1,prices,dp,having);
            dp[i] = Math.max(x,y);
            return dp[i];
        }
        else{
            int x = -prices[i]+helper(i+1,prices,dp,!having);
            int y = helper(i+1,prices,dp,having);
            dp[i] = Math.max(x,y);
            return dp[i];
        }
    }
}
