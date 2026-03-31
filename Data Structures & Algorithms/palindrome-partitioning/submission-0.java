class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        solve(0, s, path, ans);
        return ans;
    }

    static void solve(int ind, String s, List<String> path, List<List<String>> ans) {
        if (ind == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = ind; i < s.length(); i++) {
            if (isPalindrome(s, ind, i)) {
                path.add(s.substring(ind, i + 1));
                solve(i + 1, s, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }

    static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}