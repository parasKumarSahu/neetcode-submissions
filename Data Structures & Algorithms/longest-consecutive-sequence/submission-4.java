class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        
        int maxLen = Integer.MIN_VALUE;

        Map<Integer, Integer> map = new HashMap<>();
        //num, index

        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i=0; i<nums.length; i++) {
            int prev = nums[i]-1;
            if(map.containsKey(prev)) {
                //already processed as part of longer sequence
                continue;
            }
            int len = 1;
            int next = nums[i]+1;

            while(map.containsKey(next)) {
                next++;
                len++;
            }
            if(len > maxLen) {
                maxLen = len;
            }
        } 

        return maxLen;       
    }
}
