public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            if (sum < 0)
                sum = 0;
            sum += num;
            max = max > sum ? max : sum;
        }
        return max;
    }
}
/*
 * public int maxSubArray(int[] nums) {
 * int n = nums.length, ans = nums[0];
 * int[] dp = new int[n];
 * dp[0] = nums[0];
 * for (int i = 1; i < n; i++) {
 * dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
 * ans = Math.max(dp[i], ans);
 * }
 * return ans;
 * }
 */