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
    // int sum = 0;  Approach 1 : take a global variable
    
    // Approach 2: without Global Variable
    
    public int findTilt(TreeNode root) {
        if(root == null)
            return 0;
        return helper(root)[1];
    }
    
    //a[0] = sum, a[1] = tilt
    int[] helper(TreeNode root)
    {
        if(root == null)
            return new int[]{0, 0};
        
        int[] lans = helper(root.left);
        int[] rans = helper(root.right);
        
        int curSum = lans[0] + rans[0]  + root.val;
        int curTilt = lans[1] + rans[1] + Math.abs( lans[0] - rans[0] );
        
        return new int[]{ curSum, curTilt };
    }
    
}