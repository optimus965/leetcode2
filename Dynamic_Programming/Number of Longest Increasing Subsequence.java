class Solution{
    public int NumberofLIS(int n, int arr[]){
        // Code here
        int[] dp = new int[n];
        int[] parent = new int[n];
        int[] dp1 = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(dp1,1);
        int max = 0;
        for(int i =1;i < n;++i) {
            int LocalMax = 0;
            for(int j =i - 1;j >= 0;j--) {
                if(arr[i] > arr[j]) {
                    if(1 + dp[j] > dp[i]) {
                        dp[i] = 1 + dp[j];
                        max = Math.max(dp[i],max);
                        dp1[i] = dp1[j]; 
                    }
                    else if(1 + dp[j] == dp[i]) {
                        dp1[i] += dp1[j];
                    }
                    
                }
            }
        }
        int count = 0;
        for(int i =0;i < dp1.length;i++) {
            if(dp[i] == max) {
                count = count + dp1[i];
            }
        }
        
        return count;
    }
}
