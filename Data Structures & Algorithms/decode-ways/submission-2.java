class Solution {

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for(int i=0; i<n; i++) dp[i] = -1;
 
        return dpUtil(s, dp, 0);
    }

    private int dpUtil(String s, int[] dp, int i) {
        int n = s.length()-i;
        if(n == 0) return 1;

        if(dp[i] != -1) return dp[i];

        char c1 = s.charAt(i);
        if(c1 == '0') return 0;

        if(n==1 || Integer.parseInt(s.substring(i, i+2)) > 26) 
            return dp[i] = dpUtil(s, dp, i+1);
        else 
            return dp[i] = dpUtil(s, dp, i+1) + dpUtil(s, dp, i+2);
    }
}
