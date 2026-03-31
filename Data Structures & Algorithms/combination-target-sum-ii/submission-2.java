class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer>res=new ArrayList<>();
        combo(0,res,ans,nums,target);
        return ans;
        
    }
    static void combo(int ind,List<Integer> res,List<List<Integer>> ans,int nums[],int target){
        if(target==0){
            ans.add(new ArrayList<>(res));
            return;
        }
       // if(ind>=nums.length) return;
        for(int i=ind;i<nums.length;i++){
            if(i>ind&&nums[i]==nums[i-1]) continue;
            if(nums[i]>target) break;
            res.add(nums[i]);
            combo(i+1,res,ans,nums,target-nums[i]);
            res.remove(res.size()-1);
        }
    }
}
