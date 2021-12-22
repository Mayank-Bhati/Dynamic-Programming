public class minimumSumPartition {
    public static void main(String[] args) {
        int[] arr = {1,6,5,11};
        System.out.println(minDifference(arr,4));
    }
    public static int minDifference(int arr[], int n) {
        int sum = 0, min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++)
            sum += arr[i];
        boolean[][] dp = new boolean[n+1][sum+1];
        boolean call = isSubsetSum(n,arr,sum,dp);
        for(int j = 0; j <= sum; j++){
            if(dp[n][j] == true){
                int diff = Math.abs((sum-j)-j);
                min = Math.min(min,diff);
            }
        }
        return min;
    }
    static Boolean isSubsetSum(int N, int arr[], int sum, boolean[][] dp){
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
