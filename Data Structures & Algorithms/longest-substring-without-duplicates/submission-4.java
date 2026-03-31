class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        Set<Character> set=new HashSet<>();
        int res=0;
        int left=0;
        for(int right=0;right<n;right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
             set.add(s.charAt(right));
            res=Math.max(res,right-left+1);
        }
        return res;
       
        
        
    }
}
