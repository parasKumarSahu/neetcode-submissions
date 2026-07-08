class Solution {
    Boolean[][] dp;

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2 != 0) return false;

        dp = new Boolean[nums.length+1][sum/2+1];

        return util(nums, 0, 0, sum/2);
    }

    private boolean util(int[] nums, int i, int sum, int target) {
        if(sum > target) return false;

        int n = nums.length;
        if(i==n) return dp[i][sum] = (sum == target);

        if(dp[i][sum] != null) return dp[i][sum];

        return dp[i][sum] = util(nums, i+1, sum+nums[i], target) ||
        util(nums, i+1, sum, target);
    }
}
