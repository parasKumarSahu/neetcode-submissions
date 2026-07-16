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
        return util(root, Integer.MIN_VALUE);
    }

    private int util(TreeNode root, int max) {
        if(root == null)
            return 0;

        if(root.val >= max) {
            return 1+util(root.left, root.val)+util(root.right, root.val);
        } else {
            return util(root.left, max)+util(root.right, max);
        }
        
        
    }
}
