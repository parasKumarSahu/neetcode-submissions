class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int n: nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        List<int[]> pairs = new ArrayList<>(); //n, freq

        for(int n: map.keySet()) {
            pairs.add(new int[]{n, map.get(n)});
        }

        pairs.sort((a, b) -> (b[1]-a[1]));

        int[] ans = new int[k];

        for(int i=0; i<k; i++) {
            ans[i] = pairs.get(i)[0];
        }

        return ans;
    }
}
