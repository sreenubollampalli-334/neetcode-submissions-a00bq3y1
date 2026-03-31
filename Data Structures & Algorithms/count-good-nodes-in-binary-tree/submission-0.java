/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        return nodes(root,Integer.MIN_VALUE);

        
    }
    static int nodes(TreeNode root,int maxsofar){
        if(root==null) return 0;
        int cnt=0;
        if(root.val>=maxsofar) cnt=1;
        maxsofar=Math.max(maxsofar,root.val);
        cnt+=nodes(root.left,maxsofar);
        cnt+=nodes(root.right,maxsofar);
        return cnt;
    }
}
