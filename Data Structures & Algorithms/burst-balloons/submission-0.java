class Solution {
    public int maxCoins(int[] arr) {
        int n = arr.length;

        int[] nums = new int[n + 2];
        nums[0] = nums[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            nums[i + 1] = arr[i];
        }

        int[][] dp = new int[n + 2][n + 2];
        return solve(1, n, nums, dp);
    }

    int solve(int i, int j, int[] nums, int[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != 0) return dp[i][j];

        int max = 0;

        for (int k = i; k <= j; k++) {

            int coins = nums[i - 1] * nums[k] * nums[j + 1]
                      + solve(i, k - 1, nums, dp)
                      + solve(k + 1, j, nums, dp);

            max = Math.max(max, coins);
        }

        return dp[i][j] = max;
    }
}