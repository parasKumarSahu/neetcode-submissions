class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        for(int i=0; i<=amount; i++) dp[i] = -2;

        return util(coins, amount, dp);
    }

    private int util(int[] coins, int amount, int[] dp) {
        if(dp[amount] != -2) return dp[amount];
        if(amount == 0) return 0;

        int n = coins.length;
        int minAns = Integer.MAX_VALUE;

        for(int i=n-1; i>=0; i--) {
            if(amount-coins[i] < 0) continue;

            int ans = util(coins, amount-coins[i], dp);

            if(ans == -1) continue;
            else minAns = Math.min(minAns, ans);
        }

        return dp[amount] = (minAns == Integer.MAX_VALUE) ? -1 : 1+minAns;
    }
}
