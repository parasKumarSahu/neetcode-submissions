class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n<3) {
            return 0;
        }

        int[] maxLeft = new int[n];
        maxLeft[0] = height[0];
        for(int i=1; i<n; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], height[i]);
        }

        int[] maxRight = new int[n];
        maxRight[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--) {
            maxRight[i] = Math.max(maxRight[i+1], height[i]);
        }

        int ans = 0;

        for(int i=1; i<n-1; i++) {
            int water = Math.min(maxLeft[i-1], maxRight[i+1])-height[i];
            if(water>0) {
                ans += water;
            }
        }


        return ans;
    }
}
