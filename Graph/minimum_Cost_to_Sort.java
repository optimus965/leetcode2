import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
class solution {
    public void sol(int[] array) {
        int[][] nums = new int[array.length][2];
        for(int i =0;i < array.length;i++) {
            nums[i][0] = array[i];
            nums[i][1] = i;
        }
        int sum =0;
        Arrays.sort(nums,(int[] a,int[] b)->a[0] - b[0]);
        boolean[] visited = new boolean[array.length];
        for(int i = 0;i < array.length;i++) {
            if(nums[i][1] == i || visited[i]) {
                continue;
            }
            int from = i;
            List<Integer> list =new ArrayList<>();
            while(!visited[from]) {
                visited[from] = true;
                list.add(nums[from][0]);
                from = nums[from][1];
            }
            Collections.sort(list);
            int result1 = 0;
            for(int j = 1;j < list.size();j++) {
                result1 = result1 + (list.get(0)*list.get(j));
            }
            int result2 = 0;
            for (Integer integer : list) {
                result2 = result2 + (nums[0][0] * integer);
            }
            result2 = result2 + (nums[0][0]*list.get(0));
            sum = sum + Math.min(result1,result2);
        }
        System.out.println(sum);
    }
}
public class sol {
    public static void main(String[] args) {
        int[] array = new int[]{1,8,9,7,6};
        solution n =  new solution();
        n.sol(array);

    }
}
