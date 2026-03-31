

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];

        int temp1[] = new int[n-1];
        int temp2[] = new int[n-1];

        // leave first house
        for(int i = 1; i < n; i++) temp1[i-1] = nums[i];

        // leave last house
        for(int i = 0; i < n-1; i++) temp2[i] = nums[i];

        int dp1[] = new int[n-1];
        int dp2[] = new int[n-1];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        return Math.max(
            robber(n-2, temp1, dp1),
            robber(n-2, temp2, dp2)
        );
    }

    static int robber(int ind, int nums[], int dp[]) {
        if(ind < 0) return 0;
        if(ind == 0) return nums[0];

        if(dp[ind] != -1) return dp[ind];

        int not = robber(ind - 1, nums, dp);
        int take = nums[ind] + robber(ind - 2, nums, dp);

        return dp[ind] = Math.max(not, take);
    }
}