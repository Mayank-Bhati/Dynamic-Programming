import java.util.Arrays;

public class minCoinsForChange {
    public static void main(String[] args) {

    }
    static public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[][] dp = new int[amount+1][coins.length+1];
        for(int[] arr : dp)
            for(int a : arr)
                a = -1;
        int res =  utility(coins,amount,coins.length-1,dp);
        for(int[] x: dp)
        {
            System.out.println(Arrays.toString(x));
        }
        return res;
    }
    static int utility(int[] coins, int amount, int ind, int[][] dp){
        // if(ind == -1 || amount <= 0)
        //     return Integer.MAX_VALUE;
        if(ind == -1)
            return Integer.MAX_VALUE-10;
        if(amount == 0)
            return 0;
        if(dp[amount][ind] != -1)
            return dp[amount][ind];
        if(coins[ind] > amount){
            dp[amount][ind] = utility(coins,amount,ind-1,dp);
            return dp[amount][ind];
        }
        else{
            dp[amount][ind] = 1+Math.min(utility(coins,amount-coins[ind],ind,dp),
                    utility(coins,amount-coins[ind], ind-1,dp));
            return dp[amount][ind];
        }
    }
}
