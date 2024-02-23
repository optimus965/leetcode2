class Solution {
    static int shotestPath(int[][] mat, int n, int m, int k) {
        // code here
        solution sol = new solution();
        return sol.sol(mat,k);
    }
};
class Edge {
    int source;
    int destination;
    int cost;
    int k;
    public Edge(int source, int destination,int cost,int k) {
        this.source = source;
        this.destination = destination;
        this.cost  = cost;
        this.k= k;
    }
}
class solution {
    public int sol(int[][] grid,int k) {
        int n = grid.length;
        int m =   grid[0].length;
        boolean[][][] visited = new boolean[n][m][k + 1];
        Queue<Edge> que = new LinkedList<>();
        int[] dx = {0,0,1,-1};
        int[] dy= {1,-1,0,0};
        int value = (grid[0][0] == 1?1:0);
        int min = Integer.MAX_VALUE;
        que.add(new Edge(0,0,0,value));
        while(!que.isEmpty()) {
            Edge e = que.peek();
            que.remove();
            int sourcex = e.source;
            int sourcey = e.destination;
            int cost = e.cost;
            int value1 = e.k;
            visited[sourcex][sourcey][value1] = true;
            for(int i = 0;i < dx.length;i++) {
                int x = sourcex + dx[i];
                int y = sourcey + dy[i];
                if(x>= 0 && x < n && y>= 0 && y < m) {
                    int cost1 = cost + 1;
                    int k2 = value1 + (grid[x][y] == 1?1:0);
                    if( k2 <= k && !visited[x][y][k2]) {
                        if(x == n - 1 && y == m -1 ) {
                            min = Math.min(cost1,min);
                        }
                        visited[x][y][k2] = true;
                        que.add(new Edge(x,y,cost1,k2));
                    }
                    
                }
            }
        }
        return min == Integer.MAX_VALUE?-1:min;
    }
}
