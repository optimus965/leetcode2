class Solution
{
    public int max_sum(int[] a, int k1)
    {
        // Code here
        int n = a.length;
        int max = -1;
        int[][] dp = new int[n][k1];
        for(int i =0;i < n;i++) {
            dp[i][0] = a[i];
            if(k1 == 1) {
                max = Math.max(max,dp[i][0]);
            }
        }
        for(int i = 1;i < k1;i++) {
            for(int j = i;j < n;j++) {
                for(int k = j - 1;k >= 0;k--) {
                    if(a[j] >= a[k]) {
                        if(dp[k][i -1] > 0 && dp[k][i - 1] + a[j] > dp[j][i]) {
                            dp[j][i] = dp[k][i - 1] + a[j];
                            if(i == k1 - 1) {
                                max = Math.max(max, dp[j][i]);
                            }
                        }
                    }
                }
            }
        }
        return max;
    }
}
