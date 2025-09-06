import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        // dp[i][k] = true means frog can reach the end starting from stone i with last jump k
        boolean[][] dp = new boolean[n + 1][n + 1];

        // Base case: at last stone, any jump k works
        for (int k = 0; k < n; k++) {
            dp[n - 1][k] = true;
        }

        // Fill backward
        for (int i = n - 2; i >= 0; i--) {
            for (int k = 0; k < n; k++) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step <= 0) continue;
                    int nextPos = stones[i] + step;

                    // binary search for next stone
                    int j = Arrays.binarySearch(stones, i + 1, n, nextPos);

                    if (j >= 0 && dp[j][step]) {
                        dp[i][k] = true;
                        break;
                    }
                }
            }
        }

        // Start: at stone 0 with last jump = 0
        return dp[0][0];
    }
}
