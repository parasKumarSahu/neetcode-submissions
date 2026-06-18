class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int n: nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0)+1);
        }

        List<int[]> pairs = new ArrayList<>();

        for(int i: freqMap.keySet()) {
            pairs.add(new int[]{i, freqMap.get(i)});
        }

        pairs.sort((a, b) -> (b[1]-a[1]));

        int[] ans = new int[k];

        for(int i=0; i<k; i++) {
            ans[i] = pairs.get(i)[0];
        }

        return ans;
    }
}
