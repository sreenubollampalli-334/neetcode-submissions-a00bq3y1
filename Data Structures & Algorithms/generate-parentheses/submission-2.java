class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
         paran(0,0,"",ans,n);
         return ans;
        
    }
    static void paran(int open,int close,String cur,List<String> ans,int n){
        //base case
        if(cur.length()==2*n){
            ans.add(cur);
            return ;


        }
        if(open<n){
            paran(open+1,close,cur+'(',ans,n);
        }
        if(close<open){
            paran(open,close+1,cur+')',ans,n);
        }
    }
}
