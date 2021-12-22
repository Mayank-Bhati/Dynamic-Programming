import java.util.Arrays;

public class FibonacciNumber {

    public int fibTabular(int n) {
        if(n == 0 || n == 1)
            return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static long fibMemoize(int n) {
        if(n == 0 || n == 1)
            return n;
        long[] dp = new long[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;
        return helper(n,dp);
    }
   static long helper(int n, long[] dp){
        if(dp[n] != -1)
            return dp[n];
        else{
            dp[n] = helper(n-1,dp)+helper(n-2,dp);
            return dp[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(fibMemoize(1012));
    }
}
