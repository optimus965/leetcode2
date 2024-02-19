class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        solution sol =new solution();
        return sol.sol(A,X,Y);
    }
};
class Edge {
    int source;
    int destination;
    int cost;
    public Edge(int source, int destination,int cost) {
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }
}
class solution {
    public int sol(int[][] grid,int x1, int y1) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        if(grid[0][0] == 0 || grid[x1][y1] == 0) {
            return -1;
        }
        int[][] distance = new int[n][m];
        for(int i =0;i < distance.length;i++) {
            for(int j  =0;j < m;j++) {
                distance[i][j] = 9999999;
            }

        }
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<Edge> que =new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge x, Edge y) {
                if(x.cost < y.cost) {
                    return -1;
                }
                if(x.cost > y.cost) {
                    return 1;
                }
                return 0;
            }
        });
        Edge edge = new Edge(0,0,0);
        que.add(edge);
        distance[0][0] = 0;
        while(!que.isEmpty()) {
            Edge e  = que.peek();
            que.remove();
            int sourcex = e.source;
            int sourcey = e.destination;
            visited[sourcex][sourcey] = true;
            int cost = e.cost;
            for(int i = 0;i < dx.length;i++) {
                int x = sourcex + dx[i];
                int y = sourcey + dy[i];
                if(x >= 0 && x < n && y >= 0 && y < m) {
                    if(grid[x][y] == 0) {
                        continue;
                    }
                    int cost1 = cost + 1;
                    if(distance[x][y] > cost1 && !visited[x][y]) {
                        distance[x][y] = cost1;
                        Edge ev = new Edge(x,y,cost1);
                        que.add(ev);
                    }
                }
            }
        }
        if(distance[x1][y1] ==9999999) {
            return -1;
        }
        return distance[x1][y1];
    }

}
