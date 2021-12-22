public class NoOfWaysToMakeChange {
    public static void main(String[] args) {
        int n = 4;
        int[] S = {1,2,3};
        System.out.println(count(S,3,4));
    }
    public static long count(int S[], int m, int n) {
        long[][] dp = new long[m][n+1];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n+1; j++){
                dp[i][j] = -1;
            }
        }
        return helper(0,S,m,n,dp);
    }
    static long helper(int ind, int[] s, int m, int n, long[][] dp){
        if(n == 0)
            return 1;
        if(ind >= m || n < 0)
            return 0;
        if(dp[ind][n] != -1)
            return dp[ind][n];
        long take = helper(ind,s,m,(n-s[ind]),dp);
        long notTake = helper(ind+1,s,m,n,dp);
        dp[ind][n] = take+notTake;
        return dp[ind][n];
    }
}
