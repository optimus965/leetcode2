class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        // dp[i][k] = true if frog can reach stone i with jump length k
        boolean[][] dp = new boolean[n][n + 1];

        dp[0][0] = true;

        for (int i = 0; i < n; i++) {
            for (int k = 0; k <= n; k++) {
                if (dp[i][k]) {
                    for (int step = k - 1; step <= k + 1; step++) {
                        if (step > 0) {
                            int nextPos = stones[i] + step;
                            // binary search to find if nextPos exists in stones
                            int j = Arrays.binarySearch(stones, nextPos);
                            if (j >= 0) {
                                dp[j][step] = true;
                            }
                        }
                    }
                }
            }
        }

        // check last stone
        for (int k = 0; k <= n; k++) {
            if (dp[n - 1][k]) return true;
        }
        return false;
    }
}
