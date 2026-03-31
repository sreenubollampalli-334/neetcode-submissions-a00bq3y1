class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> res=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        subsets(0,res,ans,nums);
        return ans;
        
    }
    static void subsets(int ind,List<Integer> res,List<List<Integer>> ans,int nums[]){
        if(ind>=nums.length){
            ans.add(new ArrayList<>(res));
            return;
        }
        res.add(nums[ind]);
        //take case 
        subsets(ind+1,res,ans,nums);
        res.remove(res.size()-1);
        //not take
        subsets(ind+1,res,ans,nums);

    }
}
