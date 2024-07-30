
class Solution{
    static int matrixMultiplication(int n, int arr[])
    {
        int[][] dp = new int[n][n];
        for(int len = 2;len <n;len++) {
            for(int j = 0;j < n  - len;j++) {
                int end = j + len;
                int min = Integer.MAX_VALUE;
                for(int k = j + 1; k <= end;k++) {
                    int max = dp[j][k] + dp[k][end] + arr[j]*arr[k]*arr[end];
                    min = Math.min(min,max);
                    dp[j][end] = min;
                }
            }
        }
        return dp[0][n - 1];
    }
}
