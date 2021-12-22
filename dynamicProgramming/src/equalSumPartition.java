public class equalSumPartition {
    public static void main(String[] args) {
       int[] arr = {1, 5, 11, 5};
        if(equalPartition(4,arr) == 1)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
    static int equalPartition(int n, int arr[])
    {
        int sum = 0;
        for(int i = 0; i < n; i++)
            sum += arr[i];
        if(sum % 2 != 0)
            return 0;
        else
            return isSubsetSum(n,arr,sum/2)?1:0;

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
