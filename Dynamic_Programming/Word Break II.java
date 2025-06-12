class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[][] store = new boolean[n][n];
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // base case
        // Fill store[i][j] and dp
         for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                // Handle out of bounds case
                if (i < word.length() - 1) {
                    continue;
                }
                if (i == word.length() - 1 || dp[i - word.length()]) {
                    if (
                        s.substring(i - word.length() + 1, i + 1).equals(word)
                    ) {
                        dp[i] = true;
                        store[i][i - word.length() + 1] = true;
                    }
                }
            }
        }
        // Build result using store
        List<String>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (store[i][j]) {
                    String word = s.substring(j, i + 1);
                    if (j == 0) {
                        list[i].add(word);
                    } else {
                        for (String prev : list[j - 1]) {
                            list[i].add(prev + " " + word);
                        }
                    }
                }
            }
        }
        return list[n - 1];
    }
}
