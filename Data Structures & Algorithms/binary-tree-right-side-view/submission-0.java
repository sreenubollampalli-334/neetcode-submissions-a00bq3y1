class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        view(root, ans, 0);
        return ans;
    }

    private void view(TreeNode root, List<Integer> ans, int depth) {
        if (root == null) return;

        if (depth == ans.size()) {
            ans.add(root.val);
        }

        view(root.right, ans, depth + 1);
        view(root.left, ans, depth + 1);
    }
}