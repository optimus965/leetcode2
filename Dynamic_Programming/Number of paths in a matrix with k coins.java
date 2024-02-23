class Solution {
    long numberOfPath(int n, int k1, int [][]arr) {
        // code here
       int[][][] dp = new int[n][n][k1 + 1];
       if(arr[n - 1][n - 1] <= k1) {
           dp[n - 1][n - 1][k1 - arr[n - 1][n - 1]] = 1;
       }
       for(int i = n - 2;i >= 0;i--) {
          for(int k = 0;k <= k1;k++) {
              if(k + arr[n - 1][i] <= k1) {
                  dp[n - 1][i][k] += dp[n - 1][i + 1][k + arr[n - 1][i]];
              }
          }
       }
       for(int i = n - 2;i >= 0;i--) {
          for(int k = 0;k <= k1;k++) {
              if(k + arr[i][n - 1] <= k1) {
                  dp[i][n - 1][k] += dp[i + 1][n - 1][k + arr[i][n - 1]];
              }     
          }
       }
        for(int i = n - 2;i >=0;i--) {
            for(int j = n - 2;j >= 0;j--) {
                for(int k  = 0;k <=k1;k++) {
                    if(k + arr[i][j] <= k1) {
                      dp[i][j][k] += (dp[i + 1][j][k + arr[i][j]] + dp[i][j + 1][k + arr[i][j]]); 
                    }
                }
            }
        }
        return dp[0][0][0];
    }
}
