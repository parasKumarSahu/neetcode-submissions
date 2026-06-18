class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();

        for(String s: strs) {
            str.append(s.length());
            str.append("#");
            str.append(s);
        }

        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        
        int i = 0;
        while(i<str.length()) {
            StringBuilder count = new StringBuilder();
            while(str.charAt(i) != '#') {
                count.append(str.charAt(i));
                i++;
            }

            i++; //skip #

            StringBuilder s = new StringBuilder();
            for(int j=0; j<Integer.parseInt(count.toString()); j++) {
                s.append(str.charAt(i));
                i++;
            }

            ans.add(s.toString());
        }

        return ans;
    }
}
