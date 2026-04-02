

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int total = 0;
        for (int num : nums) total += num;

        if (total % 2 != 0) return false;

        int target = total / 2;

        boolean[][] dp = new boolean[n][target + 1];

        // Base case: sum = 0 is always possible
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // First element
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        // Fill DP table
        for (int i = 1; i < n; i++) {
            for (int t = 1; t <= target; t++) {

                boolean notake = dp[i - 1][t];

                boolean take = false;
                if (nums[i] <= t) {
                    take = dp[i - 1][t - nums[i]];
                }

                dp[i][t] = notake || take;
            }
        }

        return dp[n - 1][target];
    }
}