import java.util.Arrays;

public class ClimbingStairs {
//*******************************************************************************************************
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        dp[n-1] = 0;
        return helper(0,cost,dp);
    }
    static int helper(int ind, int[] cost, int[] dp){
        if(ind >= cost.length-1 )
            return 0;
        if(dp[ind] != -1)
            return dp[ind];
        else{
            dp[ind] = Math.min(cost[ind]+helper(ind+1,cost,dp),cost[ind+1]+helper(ind+2,cost,dp));
            return dp[ind];
        }
    }
//******************************************************************************************************
    public static long climbStairsEff(long n){
        long dp[] = new long[(int) (n+1)];
        for(int i = 0 ;i < 3; i++)
            dp[i] = i;
        for(int i = 3; i < n+1; i++)
            dp[i] = dp[i-1]+dp[i-2];
        return dp[(int) n];
    }
    public static int climbStairs(int n) {
        if(n == 1 || n == 2)
            return n;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        for(int i = 0; i < 3; i++)
            dp[i] = i;
        return helper(n,dp);
    }
    static int helper(int n, int[] dp){
        if(dp[n] != -1)
            return dp[n];
        else{
            dp[n] = helper(n-1,dp)+helper(n-2,dp);
            return dp[n];
        }
    }

    public static void main(String[] args) {
//        System.out.println(climbStairsEff(45));
        System.out.println(minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}
