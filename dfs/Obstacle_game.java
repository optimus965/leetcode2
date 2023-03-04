import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class solution {
    boolean[][] visited;
    Stack<List<Integer>> stack;
    int[][] x = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
    public solution(int n) {
        this.visited = new boolean[n][n];
        stack = new Stack<>();
    }
    public void sol(char[][] array,int x1,int y1) {
        if(array[x1][y1] == 'D') {
            List<Integer> list =new ArrayList<>();
            list.add(x1 + 1);
            list.add(y1 + 1);
            stack.push(list);
            System.out.println("path from the source to the destination" + "\t" + stack);
            return;
        }
        visited[x1][y1] = true;
        List<Integer> list =new ArrayList<>();
        list.add(x1 + 1);
        list.add(y1 + 1);
        stack.push(list);
        for(int i =0;i < x.length;i++) {
            int x2 = x1 + x[i][0];
            int y2 = y1 + x[i][1];
            if(x2 < 0 || y2 < 0 || x2 >= array.length || y2 >= array.length) {
                continue;
            }
            if(visited[x2][y2]) {
                continue;
            }
            if(array[x2][y2] == 'R' || array[x2][y2] == 'D') {
                sol(array, x2, y2);
            }
        }
        stack.pop();
    }
}
public class sol {
    public static void main(String[] args) {
        char[][] c = {
                {'A','S','L','W','M'},
                {'R','S','L','D','T'},
                {'M','R','T','R','M'},
                {'T','L','R','M','S'},
                {'S','L','S','W','T'},
        };
        solution n =new solution(c.length);
        n.sol(c,0,0);
    }
}
