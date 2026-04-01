class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int curprod=nums[0];
        int maxprod=nums[0];
        int minprod=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]<0){
                int temp=minprod;
                minprod=maxprod;
                maxprod=temp;
            }
            maxprod=Math.max(nums[i],nums[i]*maxprod);
            minprod=Math.min(nums[i],nums[i]*minprod);
            curprod=Math.max(curprod,maxprod);
        }
        return curprod;
    }
}
