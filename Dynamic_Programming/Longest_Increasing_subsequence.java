class Solution {
    int LCIS(int[] arr1, int n, int[] arr2, int m) {
        // code here
        int[] dp = new int[m];
        int max =0;
        Map<Integer,Boolean> map = new HashMap<>();
        Arrays.fill(dp,1);
        for(int i = 0;i < n;i++) {
            map.put(arr1[i],true);
            for(int j = 0;j < m;j++) {
                if(arr1[i] == arr2[j]) {
                    for(int k = j  - 1;k >= 0;k--) {
                        if(arr2[j] > arr2[k] && map.containsKey(arr2[k])) {
                            if(1 + dp[k] > dp[j]) {
                                dp[j] = 1 + dp[k];
                                max = Math.max(max,dp[j]);
                            } 
                        }
                    }
                    max = Math.max(max,1);
                }
            }
        }
        return max;
    }
}
