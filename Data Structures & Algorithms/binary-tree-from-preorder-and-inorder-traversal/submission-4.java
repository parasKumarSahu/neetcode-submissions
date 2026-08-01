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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return util(preorder, inorder, 0, 0, inorder.length-1);
    }

    public TreeNode util(int[] preorder, int[] inorder, int i, int j, int k) {
        if(i == preorder.length || j > k || j < 0 || k == inorder.length) {
            return null;
        }

        int val = preorder[i];
        int ind = j;

        while(ind<=k) {
            if(inorder[ind] == val)
                break;
            ind++;
        }

        return new TreeNode(val,
        util(preorder, inorder, i+1, j, ind-1),
        util(preorder, inorder, i+ind-j+1, ind+1, k));
    }
}
