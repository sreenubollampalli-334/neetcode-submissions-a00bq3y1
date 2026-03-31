

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            mp.put(inorder[i], i);
        }

        return build(preorder, 0, n - 1, inorder, 0, inorder.length - 1, mp);
    }

     TreeNode build(int[] preorder, int prestart, int preend,
                          int[] inorder, int instart, int inend,
                          HashMap<Integer, Integer> mp) {
        
        if (prestart > preend || instart > inend) return null;

        TreeNode root = new TreeNode(preorder[prestart]);
        int inroot = mp.get(root.val);
        int numsleft = inroot - instart;

        root.left = build(preorder, prestart + 1, prestart + numsleft,
                          inorder, instart, inroot - 1, mp);

        root.right = build(preorder, prestart + numsleft + 1, preend,
                           inorder, inroot + 1, inend, mp);

        return root;
    }
}