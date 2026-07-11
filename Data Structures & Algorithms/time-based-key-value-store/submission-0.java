class TimeMap {

    class Pair {
        int timestamp;
        String value;
        Pair (int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }
        List<Pair> list = map.get(key);
        int l=0, r=list.size()-1;

        String ans = "";
        while(l<=r) {
            int m = (l+r)/2;
            if(list.get(m).timestamp <= timestamp) {
                ans = list.get(m).value;
                l = m+1;
            } else {
                r = m-1;
            }
        }

        return ans;
    }
}
