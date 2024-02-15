class Solution {
    static String longestSubstring(String s, int n) {
      StringBuilder string = new StringBuilder();
        // code here
        int[][] dp = new int[n + 1][n  + 1];
        int max = 0;
        int pointer1 = -1;
        for(int i = 1;i <= n;i++) {
            for(int j = i + 1;j<=n;j++) {
                if(j > i) {
                    if(s.charAt(j - 1) == s.charAt(i - 1) && dp[i - 1][j - 1] < (j - i)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        if(dp[i][j]> max) {
                            max= dp[i][j];
                            pointer1 = i;
                        }
                    }
                }
            }
        }
        if(max > 0) {
            recur(dp,pointer1,s,string,max);
            return string.reverse().toString();
        }
        
        return "-1";
    }
    static void recur(int[][] dp,int i,String s,StringBuilder string,int max) {
        if(max == 0) {
            return;
        } 
        
        string.append(s.charAt(i - 1));
        
        recur(dp,i - 1,s,string,max  -1);
     }
};
