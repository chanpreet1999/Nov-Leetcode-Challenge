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
    
    // int sum = 0;     //approach 1 use a global variable
    public int rangeSumBST(TreeNode root, int low, int high) {
        return helper(root, low, high);
        // return sum;
    }
    
    int helper( TreeNode root, int low, int high)
    {
        if(root == null)
            return 0;
        int count = 0;
        if( root.val >= low && root.val <= high )
        {
            count += root.val;
            count += helper(root.left, low, high);
            count += helper(root.right, low, high);
        }
        else if( root.val < low )
            count += helper(root.right, low, high);
        
        else
            count += helper(root.left, low, high);
        
        return count;
    }
}