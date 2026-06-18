class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];

        int p = 1;
        for(int i=0; i<n; i++) {
            pre[i] = p;
            p *= nums[i];
        }

        p = 1;
        for(int i=n-1; i>=0; i--) {
            suf[i] = p;
            p *= nums[i];
        }

        for(int i=0; i<n; i++) {
            nums[i] = pre[i]*suf[i];
        }

        return nums;
    }
}  
