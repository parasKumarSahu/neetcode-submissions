class Solution {
    public List<String> generateParenthesis(int n) {
        Set<String> ans = new HashSet<>();
        StringBuilder curr = new StringBuilder();

        dfs(n, n, ans, curr, n);

        return new ArrayList<>(ans);
    }

    private void dfs(
        int open, int close, Set<String> ans, StringBuilder curr, int n) {
        
        if(open<0 || close<0 || open>close) return;

        if(curr.length()==2*n) {
            ans.add(curr.toString());
            return;
        }

        curr.append("(");
        open--;
        dfs(open, close, ans, curr, n);

        curr.deleteCharAt(curr.length()-1);

        curr.append(")");
        open++;
        close--;
        dfs(open, close, ans, curr, n);
        
        curr.deleteCharAt(curr.length()-1);

    }
}
