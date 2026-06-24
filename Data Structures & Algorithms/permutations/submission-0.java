class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(nums, ans, curr);

        return ans;
    }

    private void dfs(int[] nums, List<List<Integer>> ans, List<Integer> curr) {
        int n = nums.length;

        if(curr.size() == n) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int num: nums) {
            if(curr.contains(num)) continue;

            curr.add(num);
            dfs(nums, ans, curr);
            curr.remove(curr.size()-1);
        }
    }
}
