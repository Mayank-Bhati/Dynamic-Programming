public class DeleteAndEarn {
    /*
    You are given an integer array nums. You want to maximize the number of points you get by performing the
     following operation any number of times:

Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to
 nums[i] - 1 and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times.\
Input: nums = [2,2,3,3,3,4]
Output: 9
Explanation: You can perform the following operations:
- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
- Delete a 3 again to earn 3 points. nums = [3].
- Delete a 3 once more to earn 3 points. nums = [].
You earn a total of 9 points.
     */
    public static int deleteAndEarn(int[] nums) {
        int[] buckets = new int[10001];
        for(int i : nums)
            buckets[i] += i;
        int n = buckets.length;
        int[] dp = new int[n];
        if(n == 1)
            return buckets[0];
        dp[n-2] = Math.max(buckets[n-1],buckets[n-2]);
        for(int i = n-3; i >= 0; i--)
            dp[i] = Math.max(buckets[i]+dp[i+2],dp[i+1]);
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[] {2,2,3,3,3,4}));
    }
}
