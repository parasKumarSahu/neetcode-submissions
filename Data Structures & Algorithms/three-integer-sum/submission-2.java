
//[-1,0,1,2,-1,-4]

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<n-2; i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;
            ans.addAll(util(nums, i, i+1, n-1));
        }

        return ans;
    }

    public List<List<Integer>> util(
        int[] nums, int i, int start, int end) {
        int n = nums.length;
        int target = -1*nums[i];

        List<List<Integer>> ans = new ArrayList<>();

        while(start<end) {
            if(start>i+1 && nums[start]==nums[start-1]) {
                start++;
                continue;
            }
            if(end<n-1 && nums[end]==nums[end+1]) {
                end--;
                continue;
            }

            int sum = nums[start]+nums[end];
            if(sum==target) {
                ans.add(List.of(nums[i], nums[start], nums[end]));
                start++;
                end--;
            }
            else if(sum<target) start++;
            else end--;
        }

        return ans;
    }
}
