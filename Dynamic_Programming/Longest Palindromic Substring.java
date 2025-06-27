class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp =new int[s.length()][s.length()];
        for(int i =0;i < n;i++) {
            dp[i][i] = 1;
        }
        String s1 = s.charAt(0) + "";
        for(int i =1;i < n;i++) {
            for(int j = 0;j < n - i;j++) {
                int k = j + i;
                int charA = s.charAt(j);
                int charB = s.charAt(k);
                if(charA == charB && dp[j + 1][k - 1] == (k-j - 1)) {
                    dp[j][k] = 2 + dp[j + 1][k - 1];
                    if(dp[j][k] > s1.length()) {
                        s1 = s.substring(j,k + 1);
                    }
                }
            }
        }
        return s1;
    }
}
