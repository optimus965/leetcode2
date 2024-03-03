class Solution{
    static long mod = (int)1e9 + 7;
    static long countWays(int n, int sum)
    {
        int[] nums = new int[n];
        
        for(int i =0;i < n;i++) {
            nums[i] = 9;
        }
        long[][] dp = new long[n+1][sum + 1];
        for(int i =0;i <= n;i++) {
                for(int k = 0;k <= sum;k++) {
                    dp[i][k] = -1;
                }
            
        }
        int[] nums1 = new int[n - 1];
        for(int i = 0;i < n - 1;i++) {
            nums1[i] = 9;
        }
        long sum1 = recur(dp,0,sum,1,nums,1);
        if(sum1 == 0) {
            return -1;
        }
        return sum1%mod;
    }
    static long recur(long[][] dp,int index,int sum,int tight,int[] nums,int start) {
        if(index == nums.length || sum < 0) {
           if(sum == 0) {
               return 1;
           }
           return 0;
        }
        if(dp[index][sum] != -1) {
            return dp[index][sum];
        }
        int k = (tight == 1)?nums[index]:9;
        long res = 0;
        for(int i =start;i <= k;i++) {
            int newTight = (nums[index] == i)?tight:0;
            res += recur(dp,index + 1,sum - i,newTight,nums,0);
            if(res > mod) {
                res = res - mod;
            }
            
        }
        dp[index][sum] = res;
        return res;
    }
}
