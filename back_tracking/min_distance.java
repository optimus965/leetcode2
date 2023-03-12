import java.math.*;
// Java code for task 9
class solution {
    double min = Integer.MAX_VALUE;
    public void sol(int[][] nums,boolean[] previous,boolean notpair,double sum,int index,int x, int y) {
        if(index == nums.length) {
            min = Math.min(min,sum);
        }
        for(int i =0;i < nums.length;i++) {
            if(previous[i]) {
                continue;
            }
            previous[i] = true;
            if(notpair) {
                sol(nums,previous,false,sum,index + 1,nums[i][0],nums[i][1]);
            }
            else {
                double cv = Math.sqrt((nums[i][0] - x) * (nums[i][0] - x) + (nums[i][1] - y) * (nums[i][1] - y));
                        sol(nums,previous,true,sum +cv,index + 1,x,y);
            }
            previous[i] = false;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        int[][] nums = {{1,1},{8,6},{6,8},{1,3}};
        solution n =new solution();
        boolean[] visited = new boolean[nums.length];
        n.sol(nums,visited,true,0,0,-1,-1);
        System.out.println(n.min);
    }
}
