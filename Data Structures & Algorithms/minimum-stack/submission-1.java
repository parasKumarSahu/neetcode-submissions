class MinStack {

    LinkedList<Integer> stack;
    LinkedList<Integer> min;

    public MinStack() {
        stack = new LinkedList<>();
        min = new LinkedList<>();
    }
    
    public void push(int val) {
        stack.addLast(val);
        if(min.isEmpty()) {
            min.addLast(val);
        } else {
            min.addLast(Math.min(val, min.get(min.size()-1)));
        }
    }
    
    public void pop() {
        stack.removeLast();
        min.removeLast();
    }
    
    public int top() {
        return stack.get(stack.size()-1);
    }
    
    public int getMin() {
        return min.get(min.size()-1);        
    }
}
