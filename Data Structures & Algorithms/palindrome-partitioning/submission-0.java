class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        dfs(s, ans, 0, curr);

        return ans;
    }

    private void dfs(
        String s, List<List<String>> ans,
        int start, List<String> curr) {

        if(start == s.length()) {
            ans.add(new ArrayList<>(curr));
        }

        for(int i=start; i<s.length(); i++) {
            String str = s.substring(start, i+1);
            if(str.equals(new StringBuilder(str).reverse().toString())) {
                curr.add(str);
                dfs(s, ans, i+1, curr);
                curr.remove(curr.size()-1);
            }
        }

    }
}
