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
    int maxDiff = -1;
    public int maxAncestorDiff(TreeNode root) {
        if(root == null)
            return 0;
        
        helper(root, root.val, root.val);
        return maxDiff;
    }
    
    void helper(TreeNode node, int min, int max)
    {
        if(node == null)
        {
            maxDiff = Math.max(maxDiff, max - min);
            return;
        }
        
        max = Math.max( max, node.val );
        min = Math.min( min, node.val );
        
        helper(node.left, min, max);
        helper(node.right, min, max);
        
    }
}