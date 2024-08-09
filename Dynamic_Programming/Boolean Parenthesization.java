class Solution{
    static int countWays(int n, String string){
        // code here
        int[][] True = new int[n + 1][n + 1];
		int[][] False = new int[n + 1][n + 1];
		for(int i =0;i <n;i++) {
			if(string.charAt(i) == 'T') {
				True[i][i] = 1;
 			}
			else {
				False[i][i] = 1;
			}
		}
		for(int i = 1;i < n;i = i + 2) {
			for(int j = 0;j < n - i;j=j + 2) {
				int end = j + i + 1;
				for(int k = j + 1;k < end;k = k + 2) {
					if(string.charAt(k) == '|') {
						True[j][end] += True[j][k - 1]*True[k + 1][end];
						if(True[j][end] > 1003)  {
							True[j][end] %= 1003;
						}
						True[j][end] += False[j][k - 1]*True[k + 1][end];
						if(True[j][end] > 1003)  {
							True[j][end] %= 1003;
						}
						True[j][end] += True[j][k - 1]*False[k + 1][end];
						if(True[j][end] > 1003)  {
							True[j][end] %= 1003;
						}
						False[j][end] += False[j][k - 1]*False[k + 1][end];
						if(False[j][end] > 1003) {
							False[j][end] %= 1003;
						}
					}
					else if(string.charAt(k) == '^') {
						True[j][end] += False[j][k - 1]*True[k + 1][end];
						if(True[j][end] > 1003)  {
							True[j][end] %= 1003;
						}
						True[j][end] += True[j][k - 1]*False[k + 1][end];
						if(True[j][end] > 1003)  {
							True[j][end] %= 1003;
						}
						False[j][end] += True[j][k - 1]*True[k + 1][end];
						if(False[j][end] > 1003) {
							False[j][end] %= 1003;
						}
						False[j][end] += False[j][k - 1]*False[k + 1][end];
						if(False[j][end] > 1003) {
							False[j][end] %= 1003;
						}
					}
					else {
						True[j][end] += True[j][k - 1]*True[k + 1][end];
						if(True[j][end] > 1003)  {
							True[j][end] %= 1003;
						}
                        False[j][end] += True[j][k - 1]*False[k + 1][end];
                        if(False[j][end] > 1003) {
							False[j][end] %= 1003;
						}
                        False[j][end] += False[j][k - 1]*True[k + 1][end];
                        if(False[j][end] > 1003) {
							False[j][end] %= 1003;
						}
                        False[j][end] += False[j][k - 1]*False[k + 1][end];
                        if(False[j][end] > 1003) {
							False[j][end] %= 1003;
						}
					}
				}
			}
		}
		return True[0][n - 1];
    }
}
