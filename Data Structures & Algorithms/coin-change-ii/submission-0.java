class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        // Base case
        for(int amu = 0; amu <= amount; amu++) {
            if(amu % coins[0] == 0) dp[0][amu] = 1;
        }

        // Fill DP
        for(int i = 1; i < n; i++) {
            for(int amu = 0; amu <= amount; amu++) {

                int notake = dp[i - 1][amu];
                int take = 0;

                if(coins[i] <= amu) {
                    take = dp[i][amu - coins[i]];
                }

                dp[i][amu] = take + notake;
            }
        }

        return dp[n - 1][amount];
    }
}