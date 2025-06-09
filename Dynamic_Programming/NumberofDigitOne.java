class Solution {
    public int countDigitOne(int n) {
        String num = Integer.toString(n);
        int len = num.length();
        // dp[pos][count_of_ones][tight]
        int[][][] dp = new int[len + 1][len + 1][2];
        // Base Case: When pos == len (i.e., we’ve processed all digits)
        // If we are at the end of the number, we return the number of ones counted
        for (int count = 0; count <= len; count++) {
            dp[len][count][0] = count;
            dp[len][count][1] = count;
        } 
        // Fill DP table from position len-1 to 0
        for (int pos = len - 1; pos >= 0; pos--) {
            for (int count = 0; count <= pos; count++) {
                for (int tight = 0; tight <= 1; tight++) {
                    int limit = (tight == 1) ? num.charAt(pos) - '0' : 9;
                    int ans = 0;
                    for (int digit = 0; digit <= limit; digit++) {
                        int newCount = count + (digit == 1 ? 1 : 0);
                        int newTight = (tight == 1 && digit == limit) ? 1 : 0;
                        ans = (int)((ans + dp[pos + 1][newCount][newTight]) % Integer.MAX_VALUE);
                    }
                    dp[pos][count][tight] = ans;
                }
            }
        }
        // Starting from position 0, with 0 count, tight == 1 (because we're restricted to n initially)
        return dp[0][0][1];
    }
}
