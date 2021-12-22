import java.util.Arrays;

public class HouseRobber_2 {
    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        if (n == 1)
            return nums[0];
        int first = helper(1, nums, dp);
        Arrays.fill(dp,-1);
        nums[n - 1] = 0;
        int sec = helper(0, nums, dp);
        return Math.max(first, sec);
    }

    static int helper(int i, int[] nums, int[] dp) {
        if (i >= nums.length)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        else {
            int first = nums[i] + helper(i + 2, nums, dp);
            int sec = helper(i + 1, nums, dp);
            dp[i] = Math.max(first, sec);
            return dp[i];
        }
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{200,3,140,20,10}));
    }
}
