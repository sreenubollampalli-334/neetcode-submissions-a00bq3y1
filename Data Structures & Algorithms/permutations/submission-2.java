class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        permi(0,nums,ans);
        return ans;
        
    }
    static void permi(int ind,int nums[],List<List<Integer>> ans){
        List<Integer> res=new ArrayList<>();
        if(ind==nums.length){
                for(int i=0;i<nums.length;i++){
                res.add(nums[i]);
                }
                ans.add(new ArrayList<>(res));
                return;
        }
        for(int i=ind;i<nums.length;i++){
            swap(i,ind,nums);
            permi(ind+1,nums,ans);
            swap(i,ind,nums);
        }
    }
      static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
