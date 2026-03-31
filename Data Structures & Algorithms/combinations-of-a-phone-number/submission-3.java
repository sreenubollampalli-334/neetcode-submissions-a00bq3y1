class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        if(digits.length()==0) return ans;
        String map[]={
            "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        dfs(0, digits, map, new StringBuilder(), ans);
        return ans;
        
    }
    static void dfs(int ind,String digits,String map[],StringBuilder path,List<String> ans){
        if(ind==digits.length()){
            ans.add(path.toString());
            return;
        }
        String letters=map[digits.charAt(ind)-'0'];
        for(char c:letters.toCharArray()){
            path.append(c);
            dfs(ind+1,digits,map,path,ans);
            path.deleteCharAt(path.length()-1);
        }
    }
}
