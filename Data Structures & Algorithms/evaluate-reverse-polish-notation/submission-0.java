class Solution {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();

        for(String s: tokens) {
            try{
                stack.addLast(Integer.parseInt(s));
            } catch (Exception e) {
                int b = stack.removeLast();
                int a = stack.removeLast();
                int ans = 0;
                if(s.equals("+")) ans = a+b;
                else if(s.equals("-")) ans = a-b;
                else if(s.equals("*")) ans = a*b;
                else ans = a/b;

                stack.addLast(ans);
            }
        }

        return stack.removeLast();
    }
}
