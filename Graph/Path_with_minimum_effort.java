import java.util.Comparator;
import java.util.PriorityQueue;
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
    public int sol(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                distance[i][j] = 9999999;
            }
        }
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
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        distance[0][0] = 0;
        Edge1 edge = new Edge1(0,0,0);
        que.add(edge);
        while(!que.isEmpty()) {
            Edge1 e = que.peek();
            que.remove();
            int sourcex = e.i;
            int sourcey = e.j;
            visited[sourcex][sourcey] = true;
            int cost = e.cost;
            for(int i =0;i < directions.length;i++) {
                int x = sourcex + directions[i][0];
                int y = sourcey + directions[i][1];
                if(x < 0 || x >= n) {
                    continue;
                }
                if(y < 0 || y >= m) {
                    continue;
                }
                int value = Math.abs(grid[sourcex][sourcey] - grid[x][y]);
                int max = Math.max(value,cost);
              //distance[x][y] will have the max value in the current path
              // if it finds value less than max value it will update the value at distance[x][y]
              // for every iteration it will check avaliable edge which is having least effort. so that we can find the least effort needed to reach the (n - 1,m - 1) cell
              // it is dijkstra algorithm
                if(distance[x][y] > max && !visited[x][y]) {
                    distance[x][y] = max;
                    Edge1 ed = new Edge1(x,y,max);
                    que.add(ed);
                }
            }
        }
        return distance[n - 1][m - 1];
    }
}
public class Main  {
    public static void main(String[] args) {
        System.out.println("Hello, world");
        solution sol =new solution();
        int[][] grid = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(sol.sol(grid));
    }
}
