class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        solution sol = new solution();
        return sol.minPath(grid);
    }
}

class Edge1 {
    int i;
    int j;
    int cost;
    public Edge1(int i,int j,int cost) {
        this.i = i;
        this.j = j;
        this.cost = cost;
    }
}
class solution {
    public int minPath(int[][] grid) {
        int n = grid.length;
        int m= grid[0].length;
        int[][] directions  = {
                {0,1},
                {0,-1},
                {1,0},
                {-1,0}
        };
        int[][] distance = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for(int i =0;i < n;i++) {
            for(int j= 0;j < m;j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
       visited[0][0] = true;
        PriorityQueue<Edge1> que = new PriorityQueue<>(new Comparator<Edge1>() {
            @Override
            public int compare(Edge1 x, Edge1 y) {
                if(x.cost < y.cost) {
                    return -1;
                }
                if(x.cost > y.cost) {
                    return 1;
                }
                return 0;
            }
        });
        distance[0][0] = grid[0][0];
        Edge1 edgec = new Edge1(0,0,distance[0][0]);
        que.add(edgec);
        while(!que.isEmpty()) {
            Edge1 e = que.peek();
            que.remove();
            int sourcex = e.i;
            int sourcey = e.j;
            int sourcecost = e.cost;
            visited[sourcex][sourcey] = true;
            for(int i = 0;i < directions.length;i++) {
                int x = sourcex + directions[i][0];
                int y = sourcey + directions[i][1];
                if(x < 0 ||  x>= grid.length) continue;
                if(y < 0 || y >= grid[0].length) continue;
                int cost  = sourcecost + grid[x][y];
                if(distance[x][y] > cost && !visited[x][y]) {
                    distance[x][y] = cost;
                    Edge1 c = new Edge1(x,y,cost);
                    que.add(c);
                }
            }
        }
        return distance[n - 1][m - 1];
    }
}
