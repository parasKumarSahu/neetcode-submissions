
//[z, x, x]
//l = 2
//r = 2
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0) return 0;

        int l = 0, r = 0, ans = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));

        while(r<n-1) {
            r++;
            char ch = s.charAt(r);
            if(set.contains(ch)) {
                while(l<r) {
                    char tmp = s.charAt(l);
                    set.remove(tmp);
                    l++;
                    if(ch==tmp) break;
                }
            }
            set.add(ch);
            ans = Math.max(ans, r-l+1);
        }

        return ans;
    }
}
