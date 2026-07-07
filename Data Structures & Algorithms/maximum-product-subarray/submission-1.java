class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int ans = nums[0];

        for(int i=n-1; i>=0; i--) {
            int prod = 1;
            for(int j=i; j<n; j++) {
                prod *= nums[j];
                if(prod>ans) ans = prod;
            }
        }

        return ans;
    }

}
