class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        dfs(0, nums, ans, curr);

        return ans;
    }

    private void dfs(
        int ind, int[] nums, List<List<Integer>> ans, List<Integer> curr) {

        int n = nums.length;

        if(ind==n) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[ind]);
        dfs(ind+1, nums, ans, curr);

        curr.remove(curr.size()-1);
        int next = ind+1;
        while(next<n && nums[next]==nums[ind]) next++;
        dfs(next, nums, ans, curr);
        
    }
}
