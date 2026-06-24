class Solution {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        dfs(0, nums, ans, curr, 0, target);

        return ans;
    }

    private void dfs(
        int ind, int[] nums, List<List<Integer>> ans, List<Integer> curr,
        int sum, int target) {

        int n = nums.length;

        if(sum>=target) {
            if(sum==target) ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=ind; i<n; i++) {
            curr.add(nums[i]);
            dfs(i, nums, ans, curr, sum+nums[i], target);
            curr.remove(curr.size()-1);
        }
        
    }
}
