import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
class solution {
    public void sol(char[][] array) {
       Queue<int[]> que = new ArrayDeque<>();
       que.add(new int[]{0,0});
       int[][][] parent = new int[array.length][array.length][2];
       boolean[][] vis = new boolean[array.length][array.length];
       vis[0][0] = true;
       int[][] x = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
       int[] coordinates = new int[]{0,0};
       while(!que.isEmpty()) {
           int[] nums = que.poll();
           int x1= nums[0];
           int y1 = nums[1];
           boolean visited = false;
           for(int i =0;i < x.length;i++) {
               int x2 = x1 + x[i][0];
               int y2 = y1 + x[i][1];
               if(x2 < 0 || y2 < 0 || x2 >= array.length || y2 >= array.length) {
                   continue;
               }
               if(vis[x2][y2]) {
                   continue;
               }
               vis[x2][y2] = true;
               if(array[x2][y2] == 'R' || array[x2][y2] == 'D') {
                   parent[x2][y2] = new int[]{x1,y1};
                   que.add(new int[]{x2,y2});
               }
               if(array[x2][y2] == 'D') {
                   coordinates = new int[]{x2,y2};
                   visited = true;
               }
           }
           if(visited) {
               break;
           }
       }
       List<List<Integer>> list = new ArrayList<>();
        do {
            List<Integer> c = new ArrayList<>();
            int[] cv = parent[coordinates[0]][coordinates[1]];
            c.add(cv[0]);
            c.add(cv[1]);
            list.add(c);
            coordinates = cv;
        } while (coordinates[0] != 0 || coordinates[1] != 0);
       Collections.reverse(list);
       System.out.println("path from source to the destination " + " " + list);
    }
}
public class sol {
    public static void main(String[] args)  {
        solution n =new solution();
        char[][] c = {
                {'A','S','L','D'},
                {'T','R','W','R'},
                {'R','M','S','R'},
                {'W','R','R','M'}
        };
        n.sol(c);
    }
}
