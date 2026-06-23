/*
[30,38,30,36,35,40,28]
tmp = 40
stack = [28]
ans = [0,0,0,0,0,0,0]
*/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=n-1; i>=0; i--) {
            int tmp = temperatures[i];

            while(!stack.isEmpty() && temperatures[stack.peek()] <= tmp) {
                int ind = stack.pop();
                if(!stack.isEmpty()) ans[ind] = stack.peek()-ind;
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int ind = stack.pop();
            if(!stack.isEmpty()) ans[ind] = stack.peek()-ind;
        }

        return ans;
    }
}
