public class JumpGame_2 {
    /*
    Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.



Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1,
 then 3 steps to the last index.
     */

    public static int jump(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;
        int[] dp = new int[n];
        dp[n-1] = 0;
        for(int i = n-2; i >= 0; i--){
            int min = Integer.MAX_VALUE-1000;
            if(nums[i] == 0){
                dp[i] = min;
                continue;
            }
            else{
                for(int j = 1; j <= nums[i] && i+j < n; j++){
                    min = Math.min(min,dp[i+j]);
                }
                dp[i] = 1+min;
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[] {2,3,0,1,4}));
    }
}
