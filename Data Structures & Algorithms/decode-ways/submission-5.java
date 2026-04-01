class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
    return decode(0,s,dp);
        
    }
    static int decode(int i,String s,int dp[]){
        int n=s.length();
        int ways=0;
        if (i == n) return 1;

       if(dp[i]!=-1) return dp[i];
        if (s.charAt(i) == '0') return 0;
        ways+=decode(i+1,s,dp);
        if(i+1<n){
             int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');

            if(num>=10&&num<=26){
                ways+=decode(i+2,s,dp);
            }
        }
        return dp[i]=ways;
    }
}
