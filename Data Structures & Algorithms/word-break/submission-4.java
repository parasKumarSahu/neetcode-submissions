class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        
        //base condition
        dp[n] = true;
        int i = n;

        while(i>=0) {
            for(String word: wordDict) {
                int len = word.length();
                if( i+len <=n
                    && s.substring(i, i+len).equals(word) 
                    && dp[i+len]) {
                    dp[i] = true;
                    break;
                }
            }
            i--;
        }

        return dp[0];
    }

    private boolean util(String s, List<String> wordDict, int i, Boolean[] dp) {
        int n = s.length();

        if(i == n) return true;

        if(dp[i] != null) return dp[i];

        for(String word: wordDict) {
            int len = word.length();

            if( i+len <= n 
                && s.substring(i, i+len).equals(word) 
                && util(s, wordDict, i+len, dp)) {

                return dp[i] = true;
            }
        }

        return dp[i] = false;
    }
}
