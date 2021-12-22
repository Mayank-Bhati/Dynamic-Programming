import java.util.Arrays;

public class countSubsetsWithGivenSum {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 3};
        int s = 6;
        System.out.println(count(arr,4,s));
    }
    static int count(int[] arr, int n, int s){
       int[][] dp = new int[n+1][s+1];
       /* for(int i = 0; i < s+1; i++)
            dp[0][i] = 0;
        for(int i = 0; i < n+1; i++)
            dp[i][0] = 1;
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < s+1; j++) {
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][s];*/
        for(int[] a : dp)
            Arrays.fill(a,-1);
        return util(arr,n,s,dp);
    }
    static int util(int[] arr, int n, int s, int[][] dp){
        if(s == 0)
            return 1;
        if(n == 0)
            return 0;
        if(dp[n][s] != -1)
            return dp[n][s];
        if(arr[n-1] <= s){
            dp[n][s] = util(arr,n-1,s,dp)+util(arr,n-1,s-arr[n-1],dp);
            return dp[n][s];
        }
        else{
            dp[n][s] = util(arr,n-1,s,dp);
            return dp[n][s];
        }
    }
}
