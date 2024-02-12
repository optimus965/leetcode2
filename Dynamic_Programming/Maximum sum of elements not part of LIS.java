class Solution {
    static int maxSumLis(int arr[], int n) {
        // code here
        //minimize the longes subsequence sum
        int[] dp = new int[n];
        int[] sumdp = new int[n];
        sumdp[0]=arr[0];
        Arrays.fill(dp,1);
        int max = 1;
        int min = Integer.MAX_VALUE;
        for(int i = 1;i < n;i++) {
            sumdp[i] = Integer.MAX_VALUE;
            for(int j = i - 1;j >= 0;j--) {
                if(arr[i] > arr[j]) {
                    if(1 + dp[j] > dp[i]) {
                        sumdp[i]= arr[i] + sumdp[j];
                        dp[i] = 1 + dp[j];
                        max = Math.max(dp[i],max);
                    }
                    else if(1 + dp[j] == dp[i]) {
                        dp[i] = 1 + dp[j];
                        max = Math.max(dp[i],max);
                        if(arr[i] + sumdp[j] < sumdp[i]) {
                            sumdp[i]= arr[i] + sumdp[j];
                        }
                    }
                }
            }
            if(sumdp[i] == Integer.MAX_VALUE) {
                sumdp[i] = arr[i];
            }
        }
        int count  = 0;
        for(int i = 0;i < n;i++) {
            if(dp[i] == max) {
                min = Math.min(sumdp[i],min);
            }
            count = count + arr[i];
        }
        return count - min;
    }
}
