class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        int n = nums.length;

        int l = 0, r = n-1;

        while(l<=r) {
            int mid = (l+r)/2;
            min = Math.min(min, nums[mid]);
            min = Math.min(min, nums[l]);
            min = Math.min(min, nums[r]);

            if(nums[l] <= nums[mid]) l = mid+1;
            else r = mid-1;
        }

        return min;
    }
}
