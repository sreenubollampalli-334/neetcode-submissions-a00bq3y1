class Solution {
    public boolean isPalindrome(String s) {
        //StringBuilder str=new StringBuilder(s).trim();
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return ispalindrome(cleaned);
        
    }
    static boolean ispalindrome(String s){
        int l=0;
        int r=s.length()-1;
        while(l<=r){
            if(s.charAt(l++)!=s.charAt(r--)) return false;
        }
        return true;
    }
}
