import java.math.*;
import java.util.Arrays;
import java.util.Scanner;
class solution {
    public double sol(int[][] nums,boolean[] previous,int index) {
        if(index == (nums.length >> 1)) {
            return 0;
        }
        double min = Integer.MAX_VALUE;
        int x1 = 0;
        for(int  i =0;i < nums.length;i++) {
            if(!previous[i]) {
                previous[i] = true;
                x1 = i;
                break;
            }
        }
        for(int i = 0;i < nums.length;i++) {
            if(previous[i]) continue;
            previous[i] = true;
            double cv = Math.sqrt((nums[i][0] - nums[x1][0]) * (nums[i][0] - nums[x1][0]) + (nums[i][1] - nums[x1][1]) * (nums[i][1] - nums[x1][1]));
            min= Math.min(cv + sol(nums,previous,index + 1),min);
            previous[i] = false;
        }
        previous[x1] = false;
        return min;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int count = 1;
        while(true) {
            int n = scanner.nextInt();
            if(n == 0) {
                break;
            }
            int[][] nums = new int[2*n][2];
            boolean[] visited = new boolean[2*n];
            for(int i =0;i < 2*n;i++) {
                String string = scanner.next();
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                nums[i][0] = x;
                nums[i][1] = y;
            }
            solution sol =new solution();
            System.out.printf("Case %d: %.2f",(count++),sol.sol(nums,visited,0));
            System.out.println();
        }
    }
}
