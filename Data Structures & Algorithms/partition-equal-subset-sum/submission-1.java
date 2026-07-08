class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2 != 0) return false;

        return util(nums, 0, 0, sum/2);
    }

    private boolean util(int[] nums, int i, int sum, int target) {
        if(sum > target) return false;
        
        int n = nums.length;
        if(i==n) return sum == target;

        return util(nums, i+1, sum+nums[i], target) ||
        util(nums, i+1, sum, target);
    }
}
