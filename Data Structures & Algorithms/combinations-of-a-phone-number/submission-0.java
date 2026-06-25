class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        StringBuilder curr = new StringBuilder();

        dfs(digits, ans, curr);

        return ans;
    }

    private void dfs(String digits, List<String> ans, StringBuilder curr) {
        if(curr.length() == digits.length()) {
            if(curr.length()>0) ans.add(curr.toString());
            return;
        }

        String chars = getChars(digits.charAt(curr.length())); 

        for(char c: chars.toCharArray()) {
            curr.append(c);
            dfs(digits, ans, curr);
            curr.deleteCharAt(curr.length()-1);
        } 
    }

    private String getChars(char c) {
        if(c == '2') return "abc";
        if(c == '3') return "def";
        if(c == '4') return "ghi";
        if(c == '5') return "jkl";
        if(c == '6') return "mno";
        if(c == '7') return "pqrs";
        if(c == '8') return "tuv";
        if(c == '9') return "wxyz";

        return "#";
    }
}
