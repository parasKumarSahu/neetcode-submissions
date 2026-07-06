class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        
        boolean[][] dp = new boolean[n][n];

        int count = 0;

        for(int i=0; i<n; i++) {
            dp[i][i] = true;
            count++;
        }
        
        for(int len=2; len<=n; len++) {
            for(int i=0; i<=n-len; i++) {
                int j = i+len-1;

                if(s.charAt(i) != s.charAt(j)) continue;

                if(len<=3 || dp[i+1][j-1]) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
