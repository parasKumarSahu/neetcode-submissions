class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Boolean[] dp = new Boolean[n];

        return util(s, wordDict, 0, dp);
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
