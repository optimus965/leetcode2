class Solution
{
	public int minPoints(int grid[][],int n,int m) 
	{ 
	    // Your code goes here
	    int[][] dp = new int[n][m];
	    dp[n - 1][m - 1] = grid[n - 1][m - 1] > 0? 1:Math.abs(grid[n - 1][m - 1]) + 1;
	    for(int i = n - 2;i >= 0;i--) {
	        dp[i][m - 1] = Math.max(dp[i + 1][m - 1] - grid[i][m - 1],1);
	    }
	    for(int i = m -2;i >= 0;i--) {
	        dp[n - 1][i] = Math.max(dp[n - 1][i + 1] - grid[n - 1][i],1);
	    }
	    for(int i = n - 2;i >= 0;i--) {
	        for(int j = m  - 2;j >= 0;j--) {
	            int value = Math.min(dp[i + 1][j],dp[i][j + 1]);
	            dp[i][j] = Math.max(value - grid[i][j],1);
	        }
	    }
	    return dp[0][0];
	} 
}
