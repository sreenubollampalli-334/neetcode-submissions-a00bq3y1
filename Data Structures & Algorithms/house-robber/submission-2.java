class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return robber(n-1,nums,dp);
        
    }
    static int robber(int ind,int nums[],int dp[]){
        if(ind<0) return 0;
        if(ind==0) return nums[0];
        if(dp[ind]!=-1) return dp[ind];
        int not=0+robber(ind-1,nums,dp);
        int take=nums[ind]+robber(ind-2,nums,dp);
       return  dp[ind] =Math.max(not,take);

    }
}
