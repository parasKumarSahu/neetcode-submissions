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
    public boolean isValidBST(TreeNode root) {
        List<Integer> l = new ArrayList<>();

        util(root, l);

        for(int i=1; i<l.size(); i++) {
            if(l.get(i-1) >= l.get(i))
                return false;
        }

        return true;
    }

    private void util(TreeNode root, List<Integer> l) {
        if(root==null) return;
    
        util(root.left, l);
        l.add(root.val);
        util(root.right, l);
    }
}
