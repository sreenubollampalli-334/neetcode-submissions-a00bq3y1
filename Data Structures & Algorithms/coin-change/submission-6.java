class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
         int dp[][]=new int[n][amount+1];
         for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
         }
         int ans = change(n - 1, amount, coins,dp);
        
        

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
