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
    public boolean evaluateTree(TreeNode root) {
        
        if(root == null) return true;
        
        if(root.right == null && root.left == null) {
            
            return ((root.val == 0)? false:true);
        }
        
        boolean b1 = evaluateTree(root.left);
        boolean b2 = evaluateTree(root.right);
        
        if(root.val == 2) return b1 | b2;
        else return b1 & b2;
    }
}