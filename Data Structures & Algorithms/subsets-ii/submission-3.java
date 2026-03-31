class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        subsets(0,res,ans,nums);
        return ans;
        
    }
    static void subsets(int ind,List<Integer> res,List<List<Integer>> ans,int nums[]){
         ans.add(new ArrayList<>(res));
       
        if(ind>=nums.length) return;
        for(int i=ind;i<nums.length;i++){
            //this condition is to skip the duplicates
            if(i>ind&&nums[i]==nums[i-1]) continue;
            res.add(nums[i]);
            //move forward
            subsets(i+1,res,ans,nums);
            res.remove(res.size()-1);
        }
    }
}
