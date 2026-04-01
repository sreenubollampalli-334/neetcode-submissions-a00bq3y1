class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        // ✅ base case
        for (int amu = 0; amu <= amount; amu++) {
            if (amu % coins[0] == 0)
                dp[0][amu] = amu / coins[0];
            else
                dp[0][amu] = (int)1e9;
        }

        // ✅ fill table
        for (int i = 1; i < n; i++) {
            for (int amu = 0; amu <= amount; amu++) {

                int nottake = dp[i - 1][amu];

                int take = (int)1e9;
                if (coins[i] <= amu) {
                    take = 1 + dp[i][amu - coins[i]];
                }

                dp[i][amu] = Math.min(take, nottake);
            }
        }

        int ans = dp[n - 1][amount];
        return ans >= (int)1e9 ? -1 : ans;
    }
    static int change(int ind,int amount,int coins[],int dp[][]){
        //base case
        if(ind==0){
            if(amount%coins[0]==0){
                return amount/coins[0];
            }
            else{
                return (int)(1e9);
            }
        }
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        int nottake=change(ind-1,amount,coins,dp);  
        int take=(int)1e9;
        if(coins[ind]<=amount){
             take=1+change(ind,amount-coins[ind],coins,dp);
        }  
        return dp[ind][amount]=Math.min(take,nottake);

    }
}
