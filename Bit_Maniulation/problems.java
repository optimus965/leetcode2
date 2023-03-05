class Solution {
    public int[] singleNumber(int[] nums) {
        int x= 0;
        for(int i =0;i < nums.length;i++) {
            x ^= nums[i];
        }
        int diff = x&(-x);
        int xor = 0;
        for(int i =0;i < nums.length;i++) {
            if((nums[i] & diff) != 0) {
                xor = xor^nums[i];
            }
        }
        return new int[]{xor,x^xor};
    }
}
