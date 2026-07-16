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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root!=null) q.add(root);

        while(!q.isEmpty()) {
            int n = q.size();
            for(int i=0; i<n; i++) {
                TreeNode tmp = q.poll();
                if(tmp.left!=null) q.offer(tmp.left);
                if(tmp.right!=null) q.offer(tmp.right);

                if(i==n-1) ans.add(tmp.val);
            }
        }

        return ans;
    }
}
