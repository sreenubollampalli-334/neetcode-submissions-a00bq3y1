class Solution {
    public int countSubstrings(String s) {
        return count(0, s);
    }

    static int count(int ind, String s) {
        int n = s.length();

        // base case
        if (ind == n) return 0;

        int cnt = 0;

        // check all substrings starting from index 'ind'
        for (int i = ind; i < n; i++) {
            if (ispalindrome(ind, i, s)) cnt++;
        }

        // ✅ include recursive result
        return cnt + count(ind + 1, s);
    }

    static boolean ispalindrome(int l, int r, String s) {
        while (l <= r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}