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
    int max = 0;
    public int rob(TreeNode root) {
        int ans[] = helper(root);
        return Math.max( ans[0], ans[1] );
    }
    
    // 0 -> do not include cur
    // 1 -> include cur
    int[] helper( TreeNode root)
    {
        if(root == null)
            return new int[]{0, 0};
        
        int lAns[] = helper(root.left);
        int rAns[] = helper(root.right);
        
        int myAns[] = new int[2];
        
        myAns[0] = Math.max(lAns[0], lAns[1]) + Math.max(rAns[0], rAns[1]);
        myAns[1] = lAns[0] + root.val + rAns[0];
        
        return myAns;
    }
}