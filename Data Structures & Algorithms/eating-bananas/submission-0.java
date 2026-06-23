class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int l = 1, r = 1000000000;

        while(l<r) {
            int mid = (l+r)/2;
            int time = getTime(mid, piles);

            if(time<=h) r = mid;
            else l = mid+1;
        }
        
        return l;
    }

    private int getTime(int speed, int[] piles) {
        int time = 0;

        for(int p: piles) {
            time += p/speed;
            if(p%speed != 0) time++;
        }

        return time;
    }
}
