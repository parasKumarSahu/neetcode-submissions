class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        dfs(nums, ans, curr, set);

        return ans;
    }

    private void dfs(
        int[] nums, List<List<Integer>> ans, List<Integer> curr, Set<Integer> set) {
        
        int n = nums.length;

        if(curr.size() == n) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int num: nums) {
            if(set.contains(num)) continue;

            curr.add(num);
            set.add(num);
            dfs(nums, ans, curr, set);
            curr.remove(curr.size()-1);
            set.remove(num);
        }
    }
}
