class Solution {
    public int numDistinct(String s, String t) {
        return distinct(s.length() - 1, t.length() - 1, s, t);
    }

    static int distinct(int i, int j, String s, String t) {
        // Base cases
        if (j < 0) return 1;  // t matched
        if (i < 0) return 0;  // s exhausted

        if (s.charAt(i) == t.charAt(j)) {
            return distinct(i - 1, j - 1, s, t)   // take
                 + distinct(i - 1, j, s, t);      // skip
        } else {
            return distinct(i - 1, j, s, t);      // skip only
        }
    }
}