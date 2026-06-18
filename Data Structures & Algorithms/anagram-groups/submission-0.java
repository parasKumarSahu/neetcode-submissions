class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> mapOfFreqMap = new HashMap<>();
        
        for(String str: strs) {
            Map<Character, Integer> freqMap = new HashMap<>();
            for(char c: str.toCharArray()) {
                freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
            }
            List<String> list = mapOfFreqMap.getOrDefault(freqMap, new ArrayList<>());
            list.add(str);
            mapOfFreqMap.put(freqMap, list);
        }

        List<List<String>> ans = new ArrayList<>();
        
        for(List<String> l: mapOfFreqMap.values()) {
            ans.add(l);
        }

        return ans;
    }
}
