import java.util.Scanner;
import java.util.Arrays;
public class sol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row;
        int col;
        int counter = 1;
        do {
            row = scanner.nextInt();
            col = scanner.nextInt();
            if(row == 0 && col == 0) {
                break;
            }
            char[][] grid = new char[row][col];
            int[][] dp = new int[row + 1][col + 1];
            for (int i = 0; i < row; i++) {
                String s = scanner.next();
                grid[i] = s.toCharArray();
            }
            solution n = new solution();
            int max = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 'A') {
                        for (int[] c : dp) {
                            Arrays.fill(c, -1);
                        }
                        max = Math.max(max, n.sol(grid, i, j, dp));
                    }
                }
            }
            System.out.println("Case" + "  " +  (counter++) + ":" + "  " +  max);
        }
        while(row != 0 && col != 0);

    }
}
class solution {
    int[][] directions = {
            {-1,-1},
            {-1,0},
            {-1,1},
            {0,1},
            {1,1},
            {1,0},
            {1,-1},
            {0,-1},
    };
    public int sol(char[][] grid, int row, int col,int[][] dp) {
        if(dp[row][col] != -1) {
            return dp[row][col];
        }
        int consecutive = 1;
        for(int i =0;i < directions.length;i++) {
            int new_row = row + directions[i][0];
            int new_col = col + directions[i][1];
            if(new_row >= grid.length || new_row < 0 || new_col < 0 || new_col >= grid[0].length) {
                continue;
            }
            if(grid[new_row][new_col] - grid[row][col] == 1) {
                consecutive = Math.max(consecutive,1 + sol(grid,new_row,new_col,dp));
            }
        }
        dp[row][col] = consecutive;
        return consecutive;
    }
}
