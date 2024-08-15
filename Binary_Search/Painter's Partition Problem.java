import java.util.ArrayList;

public class Solution 
{
    public static int findLargestMinDistance(ArrayList<Integer> arr, int k)
    {
        //    Write your code here.
        int[] nums = new int[arr.size()];
        int max = -1;
        int sum = 0;
        int ans = -1;
        int n = nums.length;
        for(int i =0;i < n;i++) {
            nums[i] = arr.get(i);
            sum = sum + nums[i];
            max = Math.max(max,nums[i]);
        }
        int low = max;
        int high = sum;
        while(low <= high) {
            int mid = (low + high) >> 1;
            int count = 0;
            sum = 0;
            for(int i =0;i < n;i++) {
                if(sum + nums[i] > mid) {
                    if(sum <= mid) {
                        count = count + 1;
                    }
                   sum = nums[i];
                }
                else {
                    sum = sum + nums[i];
                }
            }
            if(sum <= mid) {
                count = count + 1;
            }
            if(count <= k) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
       
    }
}
