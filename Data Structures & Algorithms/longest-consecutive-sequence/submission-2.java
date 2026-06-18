class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();

        for(int n: nums) {
            set.add(n);
        }

        int maxLen = -1;

        for(int n: set) {
            if(!set.contains(n-1)) {
                int i = n+1, count = 1;
                while(set.contains(i)) {
                    count++;
                    i++;
                }
                
                maxLen = Math.max(maxLen, count);
            }
        }

        return maxLen;
    }
}
