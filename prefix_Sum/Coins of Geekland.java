class Solution
{
    public int Maximum_Sum(int a[][],int N,int k){
        int[][] prefix = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            prefix[1][i] = prefix[1][i - 1] + a[0][i - 1];
        }
        for (int i = 1; i <= N; i++) {
            prefix[i][1] = prefix[i - 1][1] + a[i - 1][0];
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= N; j++) {
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1]
                        - prefix[i - 1][j - 1] + a[i - 1][j - 1];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = k; i <= N;i++) {
            for(int j =  k;j <= N;j++) {
               int total = prefix[i][j]  - prefix[i - k][j] - prefix[i][j - k] + prefix[i - k][j - k];
               max = Math.max(max,total);
            }
        }
        return max;        
    }
}
