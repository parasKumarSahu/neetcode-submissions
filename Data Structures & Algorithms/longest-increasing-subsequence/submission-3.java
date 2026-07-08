class Solution {

//1,3,6,7,9,4,10,5,6
//1,2,3,4,5,3,6
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;

        for(int i=1; i<n; i++) {

            for(int j = i-1; j>=0; j--) {
                if(nums[j] < nums[i]) 
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            
            if(dp[i] == 0) {
                dp[i] = 1;
            } 
        }

        return Arrays.stream(dp).max().getAsInt();
    }

}
