class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> mp1 = new HashMap<>();
        HashMap<Character, Integer> mp2 = new HashMap<>();

        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            mp1.put(c1, mp1.getOrDefault(c1, 0) + 1);
            mp2.put(c2, mp2.getOrDefault(c2, 0) + 1);
        }

        return mp1.equals(mp2);
    }
}