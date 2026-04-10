class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return distance(word1.length() - 1, word2.length() - 1, word1, word2,dp);
    }

    static int distance(int i, int j, String s, String t,int dp[][]) {
        // Base cases
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;
        if(dp[i][j]!=-1) return dp[i][j];

        // If characters match
        if (s.charAt(i) == t.charAt(j)) {
            return distance(i - 1, j - 1, s, t,dp);
        }

        // Operations
        int insert = 1 + distance(i, j - 1, s, t,dp);
        int delete = 1 + distance(i - 1, j, s, t,dp);
        int replace = 1 + distance(i - 1, j - 1, s, t,dp);

        return dp[i][j]=Math.min(insert, Math.min(delete, replace));
    }
}