class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        int ans = nums[0];

        dp[0] = nums[0];
        dp2[0] = nums[0];

        for(int i=1; i<n; i++) {
            dp[i] = Math.max(
                Math.max(nums[i], nums[i]*dp[i-1]), nums[i]*dp2[i-1]
            );

            if(ans < dp[i]) ans = dp[i];

            dp2[i] = Math.min(
                Math.min(nums[i], nums[i]*dp2[i-1]), nums[i]*dp[i-1]
            );
        }

        return ans;
    }

}
