class Solution {
    //AAABABB.  k=1
    //l = 1
    //r = 5
    //ch = B
    //ans = 5
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0, r = 0, ans = 1;
        int[] alpha = new int[26];
        alpha[s.charAt(0)-'A'] += 1;

        while(r<n-1) {
            r++;
            char ch = s.charAt(r);
            alpha[ch-'A'] += 1;

            while(l<r && !hasOnlyOneCharAfterK(alpha, k)) {
                char tmp = s.charAt(l);
                alpha[tmp-'A'] -= 1;
                l++;
            }

            ans = Math.max(ans, r-l+1);
        }

        return ans;
    }

    private boolean hasOnlyOneCharAfterK(int[] alpha, int k) {
        int sum = 0, max = 0;

        for(int a: alpha) {
            max = Math.max(max, a);
            sum += a;
        }

        return k >= sum-max;
    }
}
