class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        combo(0,res,ans,nums,target);
        return ans;

        
    }
    static void combo(int ind,List<Integer> res,List<List<Integer>>ans,int nums[],int target){
        if(target==0){
            ans.add(new ArrayList<>(res));
            return;
        }
         if (ind >= nums.length) return;
        if(nums[ind]<=target){
            res.add(nums[ind]);
            combo(ind,res,ans,nums,target-nums[ind]);
            res.remove(res.size()-1);
        }
        combo(ind+1,res,ans,nums,target);

    }
}
