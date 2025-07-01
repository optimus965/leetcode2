class Solution {
    int[][] directions = {
        {0,1},
        {0,-1},
        {1,0},
        {-1,0}
    };
  // it is multi source bfs
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> que = new ArrayDeque<>();
        for(int i =0;i < n;i++) {
            for(int j =0;j < m;j++) {
                int value = grid[i][j];
                if(value == 2) {
                    que.add(new int[]{i,j,0});
                }
            }
        }
        boolean[][] visited = new boolean[n][m];
        int max = 0;
        while(!que.isEmpty()) {
            int[] peek = que.poll();
            int x = peek[0];
            int y = peek[1];
            int distance = peek[2];
            max = Math.max(max,distance);
            visited[x][y] = true;
            for(int i =0;i < directions.length;i++) {
                int x1 = x + directions[i][0];
                int y1 = y + directions[i][1];
                if(x1 < 0 || x1 >= n || y1 < 0 || y1 >= m) {
                    continue;
                }
                if(visited[x1][y1]) {
                    continue;
                }
                visited[x1][y1] = true;
                if(grid[x1][y1] == 1) {
                    que.add(new int[]{x1,y1,distance + 1});
                }
            }
        }
        for(int i =0;i < n;i++) {
            for(int j =0;j < m;j++) {
                if(grid[i][j] == 1 && visited[i][j] == false) {
                    return -1;
                }
            }
        }
        return max;
    }
}
