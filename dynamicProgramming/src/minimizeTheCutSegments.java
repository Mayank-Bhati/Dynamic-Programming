public class minimizeTheCutSegments {
    public static void main(String[] args) {
        System.out.println(maximizeCuts(5,5,3,2));
    }
    public static int maximizeCuts(int n, int x, int y, int z){
        int[] dp = new int[n+1];
        for(int i = 0; i <= n; i++)
            dp[i] = -1;
        dp[0] = 0;
                for(int i = 0; i <= n; i++){
                    if(dp[i] == -1)
                        continue;
                    if(i+x <= n)
                        dp[i+x] = Math.max(dp[i+x],1+dp[i]);
                    if (i+y <= n)
                        dp[i+y] = Math.max(dp[i+y],1+dp[i]);
                    if(i+z <= n)
                        dp[i+z] = Math.max(dp[i+z],1+dp[i]);
                }
        return (dp[n] == -1)?0:dp[n];
    }

}
