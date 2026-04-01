class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
         int ans = change(n - 1, amount, coins);

        return ans >= (int)1e9 ? -1 : ans;
       
        
    }
    static int change(int ind,int amount,int coins[]){
        //base case
        if(ind==0){
            if(amount%coins[0]==0){
                return amount/coins[0];
            }
            else{
                return (int)(1e9);
            }
        }

        int nottake=change(ind-1,amount,coins);  
        int take=(int)1e9;
        if(coins[ind]<=amount){
             take=1+change(ind,amount-coins[ind],coins);
        }  
        return Math.min(take,nottake);

    }
}
