class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] check = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            check[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            check[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && check[i + 1][j - 1]) {
                    check[i][j] = true;
                }
            }
        }
        List<List<String>>[][] dp = new ArrayList[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = new ArrayList<>();
            }
        }
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < n && i <= n - len; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    if (check[i][k]) {
                        String string1 = s.substring(i,k + 1);
                        if(k == j) {
                            List<String> list =new ArrayList<>();
                            list.add(string1);
                            dp[i][j].add(list);
                        }
                        else {
                            for(List<String> list:dp[k + 1][j]) {
                                List<String> list1 = new ArrayList<>();
                                list1.add(string1);
                                list1.addAll(list);
                                dp[i][j].add(list1);
                            }
                        }
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}

// Palindrome Partitioning 2

class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] check = new boolean[n][n];
        for(int i =0;i < s.length();i++) {
            check[i][i] = true;
        }
        for(int i =0;i < n - 1;i++) {
            check[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        for(int len = 3;len <= n;len++) {
            for(int i = 0;i < n && i <= n - len;i++) {
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j) && check[i + 1][j - 1]) {
                    check[i][j] = true;
                }
            }
        }
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < n;j++) {
                dp[i][j] = (int)1e9;
            }
        }
        for(int i =0;i <= n;i++) {
            dp[i][i] = 0;
            if(i < n - 1) {
                if(s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1]  = 0;
                }
                else {
                    dp[i][i + 1] = 1;
                }
            }
        }
        for(int len = 3;len <= n;len++) {
            for(int i =0;i < n && i <= n - len;i++) {
                int j = i + len - 1;
                if(check[i][j]) {
                    dp[i][j] = 0;
                    continue;
                }
                for(int k = i;k < j;k++) {
                    if(check[i][k]) {
                        dp[i][j] = Math.min(1 + dp[k + 1][j],dp[i][j]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
