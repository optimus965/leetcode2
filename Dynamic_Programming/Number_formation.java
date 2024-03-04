class Solution {
   int mod = 1000000007;
    public int getSum(int x, int y, int z) {
       solution sol = new solution();
       sol.m(x,y,z);
       return (int)(sol.total%mod);
    }
}
class solution {
    private final int mod = 1000000007;
    long total = 0;
    long[][][] dp1;
    long[][][] dp2;
    public void m(int x, int y, int z) {
        dp1 = new long[x + 1][y + 1][z + 1];
        dp2 = new long[x + 1][y + 1][z + 1];
        for(int i =0;i <=x ;i++) {
            for(int j = 0;j <= y;j++) {
                for(int k = 0;k <= z;k++) {
                    dp1[i][j][k] = -1;
                    dp2[i][j][k] = -1;
                }
            }
        }
        calculateSum(x,y,z);
    }

    public int getSum(int x, int y, int z) {
        long ans = calculateSum(x, y, z);
        return (int) (ans % mod);
    }
    public long calculateSum(int i, int j, int k) {
        if (i < 0 || j < 0 || k < 0) return 0;
       if(dp1[i][j][k] != -1) {
           return dp1[i][j][k];
       }
        long exactSum = 0;
        if (i > 0) {
            exactSum += (calculateSum(i - 1, j, k) * 10 + 4 * calculateNum(i - 1, j, k)) % mod;
        }
        if (j > 0) {
            exactSum += (calculateSum(i, j - 1, k) * 10 + 5 * calculateNum(i, j - 1, k)) % mod;
           
        }
        if (k > 0) {
            exactSum += (calculateSum(i, j, k - 1) * 10 + 6 * calculateNum(i, j, k - 1)) % mod;
        }
        long sum = exactSum;
        if(sum > mod) {
            sum -= mod;
        }
        dp1[i][j][k] =sum;
        total  = total + sum;
        if(total > mod) {
            total -= mod;
        }
       
        return sum;
    }

    private long calculateNum(int i, int j, int k) {
        if (i < 0 || j < 0 || k < 0) return 0;
        if(i ==0 && j == 0 && k == 0) {
            return 1;
        }
        if(dp2[i][j][k] != -1) {
            return dp2[i][j][k];
        }
        long num = 0;
        num += calculateNum(i - 1, j, k);
         if(num > mod) {
            num -= mod;
        }
        num += calculateNum(i, j - 1, k);
         if(num > mod) {
            num -= mod;
        }
        num += calculateNum(i, j, k - 1);
         if(num > mod) {
            num -= mod;
        }
       
        dp2[i][j][k] = num;
        return num;
    }
}
