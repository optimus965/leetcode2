class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max =Integer.MIN_VALUE;
        int n = piles.length;
        for(int i = 0;i < n;i++) {
            max = Math.max(max,piles[i]);
        }
        int low = 1;
        int high = max;
        while(low <= high) {
            int mid = low + (high - low)/2;
            long count = 0;
            for(int i =0;i < n;i++) {
                if(piles[i] <= mid) {
                    count++;
                }
                else {
                    int value = piles[i]/mid;
                    if(piles[i]%mid == 0) {
                        count = count + value;
                    }
                    else {
                        count = count + value + 1;
                    }
                }
            }
          // if the taken size it very high reduce the size 
            if(count <= (long)h) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}
