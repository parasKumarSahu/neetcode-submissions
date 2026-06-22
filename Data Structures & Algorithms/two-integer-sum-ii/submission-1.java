
//[2, 3, 4]
//    s   e
//sum = 7
//target = 6

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int start = 0, end = n-1;

        while(end<n) {
            int sum = numbers[start]+numbers[end];
            if(sum==target) break;
            else if(sum<target) start++;
            else end--;
        }

        return new int[]{start+1, end+1};
    }
}
