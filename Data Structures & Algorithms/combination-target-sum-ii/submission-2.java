class Solution {

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        dfs(0, nums, ans, curr, 0, target);

        return ans;
    }

    private void dfs(
        int ind, int[] nums, List<List<Integer>> ans, List<Integer> curr,
        int sum, int target) {

        int n = nums.length;

        if(ind==n || sum>=target) {
            if(sum==target && (ans.isEmpty() || !ans.get(ans.size()-1).equals(curr))) 
                ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[ind]);
        dfs(ind+1, nums, ans, curr, sum+nums[ind], target);

        curr.remove(curr.size()-1);
        int next = ind+1;
        while(next<n && nums[ind]==nums[next]) next++;
        dfs(next, nums, ans, curr, sum, target);
        
    }
}
