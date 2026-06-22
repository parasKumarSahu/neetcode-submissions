class Solution {
    public int maxArea(int[] heights) {
        int ans = 0, n = heights.length;

        int l = 0, r = n-1;

        while(l<r) {
            int hl = heights[l];
            int hr = heights[r];
            ans = Math.max(ans, (r-l)*Math.min(hl, hr));
            
            if(hl<hr) {
                l++;
            } else {
                r--;
            }
        } 

        return ans;
    }
}
