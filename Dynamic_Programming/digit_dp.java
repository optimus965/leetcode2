class Solution {
    public int countDigitOne(int n) {
        return this.sol(n);
    }
    public int sol(int n) {
        int count = 0;
        int temp = n;
        while(temp > 0) {
            count++;
            temp = temp/10;
        }
        int[][][] dp = new int[count + 1][10][2];
        for(int[][] x:dp) {
            for(int[] c:x) {
                Arrays.fill(c,-1);
            }
        }
        count = (int)Math.pow(10,count - 1);
        int ans = this.dy(dp,0,0,0,n,count);
        return ans;
    }
    public int dy(int[][][] dp,int index,int sum,int state,int number,int count) {
        if(index == dp.length - 1) {
            return sum;
        }
        if(dp[index][sum][state] != -1) {
            return dp[index][sum][state];
        }
        int pos = number/count;
        int max_limit = pos%10;
        int ans = 0;
        if(state == 0) {
            int i;
            for(i = 0;i < max_limit;i++) {
                ans = ans + dy(dp,index + 1, sum + (i == 1?1:0),1,number,count/10);
            }
            ans = ans + dy(dp,index + 1, sum + (i == 1?1:0),0,number,count/10);
        }
        else {
            for(int i = 0;i <= 9;i++) {
                ans = ans + dy(dp,index + 1, sum + (i == 1?1:0),1,number,count/10);
            }
        }
        dp[index][sum][state] = ans;
        return ans;
    }
}
