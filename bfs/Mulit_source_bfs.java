import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
class Pair {
    int row;
    int col;
    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
class solution {
    public int sol(int[][] matrix,int max) {
        int[][] directions = {
                {0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,1},{1,-1}
        };
        Queue<Pair> que = new ArrayDeque<>();
        int ans = 0;
        int[][] distance = new int[matrix.length][matrix[0].length];
        for(int i =0;i < distance.length;i++) {
            for(int j =0;j < distance[0].length;j++) {
                distance[i][j] = (int)1e9;
            }
        }
        for(int i =0;i < matrix.length;i++) {
            for(int j =0;j < matrix[0].length;j++) {
                if(matrix[i][j] == max) {
                    que.add(new Pair(i,j));
                    distance[i][j] = 0;
                }
            }
        }
        // Multi Source BFS
        while(!que.isEmpty()) {
            int row = que.peek().row;
            int col = que.peek().col;
            que.poll();
            for (int i = 0; i < directions.length; i++) {
                int r1 = row + directions[i][0];
                int c1 = col + directions[i][1];
                if (r1 < 0 || c1 < 0 || r1 >= matrix.length || c1 >= matrix[0].length || distance[r1][c1] <= distance[row][col] + 1) {
                    continue;
                }
                que.add(new Pair(r1,c1));
                distance[r1][c1] = distance[row][col] + 1;
                ans= Math.max(ans,distance[r1][c1]);
            }
        }

        return ans;

    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n;i++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] matrix = new int[rows][cols];
            int max = 0;
            for(int j = 0;j < rows;j++) {
                for(int k = 0;k < cols;k++) {
                    matrix[j][k] = scanner.nextInt();
                    max = Math.max(matrix[j][k],max);
                }
            }
            solution sol = new solution();
            System.out.println(sol.sol(matrix,max));


        }
    }
}
