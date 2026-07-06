class Solution {

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];

        //base case
        dp[n] = 1;

        for(int i=n-1; i>=0; i--) {
            int len = s.length()-i;
            char c1 = s.charAt(i);
            
            if(c1 == '0') 
                dp[i] = 0;
            else if(len==1 || Integer.parseInt(s.substring(i, i+2)) > 26) 
                dp[i] = dp[i+1];
            else
                dp[i] = dp[i+1]+dp[i+2];

        }
 
        return dp[0];
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
