public class subsetSum {
    public static void main(String[] args) {
      int  arr[] = {3, 34, 4, 12, 5, 2};
      int sum = 9;
        System.out.println(isSubsetSum(6,arr,sum));
    }
    static Boolean isSubsetSum(int N, int arr[], int sum){
        boolean[][] dp = new boolean[N+1][sum+1];
        for(int j = 0; j < sum+1; j++)
            dp[0][j] = false;
        for(int j = 0; j < N+1; j++)
            dp[j][0] = true;
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < sum+1; j++){
                if(arr[i-1] <= j)
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[N][sum];
    }
}
