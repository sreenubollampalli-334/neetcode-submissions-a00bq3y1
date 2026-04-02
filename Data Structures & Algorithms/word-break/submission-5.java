

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);

        return canBreak(n, s, new HashSet<>(wordDict), dp);
    }

    static boolean canBreak(int ind, String s, Set<String> set, int dp[]) {
        if (ind == 0) return true;

        if (dp[ind] != -1) return dp[ind] == 1;

        for (int i = 0; i < ind; i++) {
            if (canBreak(i, s, set, dp) && set.contains(s.substring(i, ind))) {
                dp[ind] = 1;
                return true;
            }
        }

        dp[ind] = 0;
        return false;
    }
}