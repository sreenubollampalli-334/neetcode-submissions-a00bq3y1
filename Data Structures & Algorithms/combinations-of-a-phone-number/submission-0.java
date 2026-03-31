class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;

        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        dfs(0, digits, map, new StringBuilder(), result);
        return result;
    }

    private void dfs(int index, String digits, String[] map, 
                     StringBuilder path, List<String> result) {

        // Base case
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            path.append(c);                 // choose
            dfs(index + 1, digits, map, path, result); // explore
            path.deleteCharAt(path.length() - 1); // backtrack
        }
    }
}