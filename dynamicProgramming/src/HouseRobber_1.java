import java.util.Arrays;

public class HouseRobber_1 {

    public static int robEff(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        dp[n-1] = nums[n-1];
        dp[n-2] = Math.max(nums[n-2],nums[n-1]);
        for(int i = n-3; i >= 0; i--){
            dp[i] = Math.max(nums[i]+dp[i+2],dp[i+1]);
        }
        return dp[0];
    }
    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if(n == 1)
            return nums[0];
        Arrays.fill(dp,-1);
        dp[n-1] = nums[n-1];
        return helper(0,nums,dp);
    }
    static int helper(int ind, int[] nums, int[] dp){
        if(ind >= nums.length)
            return 0;
        if(dp[ind] != -1)
            return dp[ind];
        else{
            int first = nums[ind]+helper(ind+2,nums,dp);
            int sec = helper(ind+1,nums,dp);
            dp[ind] = Math.max(first,sec);
            return dp[ind];
        }
    }

    public static void main(String[] args) {
        System.out.println(robEff(new int[] {2,7,9,3,1}));
    }
}
