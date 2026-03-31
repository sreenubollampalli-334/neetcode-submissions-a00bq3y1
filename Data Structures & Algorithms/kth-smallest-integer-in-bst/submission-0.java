class Solution {
    int count = 0;
    int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        smallest(root, k);
        return res;
    }

    private void smallest(TreeNode root, int k) {
        if (root == null) return;

        smallest(root.left, k);

        count++;
        if (count == k) {
            res = root.val;
            return;
        }

        smallest(root.right, k);
    }
}