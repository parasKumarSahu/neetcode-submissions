/*
pos = 3 4 5 6 7 8
tim = 2 2 2 1 1 1

s   = 1
*/
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Stack<Double> stack = new Stack<>();
        Integer[] arr = new Integer[n];

        for(int i=0; i<n; i++) {
            arr[i] = i;
        }

        Arrays.sort(arr, (a, b) -> (position[a]-position[b]));

        for(int i=n-1; i>=0; i--) {
            Double time = getTime(position[arr[i]], speed[arr[i]], target);

            if(stack.isEmpty() || stack.peek()<time) stack.push(time);
        }

        return stack.size();
    }

    private Double getTime(int pos, int s, int target) {
        return ((double)(target-pos))/s;
    }
}
