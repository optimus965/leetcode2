class Solution{
    static int waysToIncreaseLCSBy(int n,String string1,int m,String string2)
    {
        // code here
        int[][] dp =new int[n + 2][m + 2];
        int[][] sdp = new int[n + 2][m + 2];
        Vector<Integer>[] positions = new Vector[26];
        for(int i = 0;i < 26;i++) {
            positions[i] = new Vector<>();
        }
        for(int i = 1;i <= m;i++) {
            positions[(string2.charAt(i - 1) - 'a')].add(i);
        }
        for(int i =1;i <= n;i++) {
            for(int j = 1;j <= m;j++) {
                if(string1.charAt(i - 1) == string2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        for(int i = n;i >= 1;i--) {
            for(int j = m;j >= 1;j--) {
                if(string1.charAt(i - 1) == string2.charAt(j - 1)) {
                    sdp[i][j] = sdp[i + 1][j + 1] + 1;
                }
                else {
                    sdp[i][j] = Math.max(sdp[i + 1][j],sdp[i][j + 1]);
                }
            }
        }
        int count = 0;
        for(int i = 0;i <= n;i++) {
            for(int j = 0;j < 26;j++) {
                for(int k = 0;k < positions[j].size();k++) {
                    int cv = positions[j].elementAt(k);
                    if((dp[i][cv - 1] + sdp[i + 1][cv + 1] == dp[n][m])) {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
}
