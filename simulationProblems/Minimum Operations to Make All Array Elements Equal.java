// prefix sum  + sorting + binary search
class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        List<Long> list =new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        long[] prefix = new long[nums.length + 1];
        prefix[1] = (long)nums[0];
        for(int i = 2;i <= n;i++) {
            prefix[i] = prefix[i - 1] + (long)nums[i - 1];
        }
        for(int i = 0;i < queries.length;i++) {
            int num1  = queries[i];
            int low = 0;
            int high = n;
            while(low < high) {
                int mid = low + (high - low)/2;
                if(nums[mid] >= num1) {
                    high = mid;
                }
                else {
                   low = mid + 1;
                }
            }
            long sum1 = prefix[n] - prefix[low];
            long secondHalf = sum1 - 1L*(n - low)*num1;
            long sum2 = prefix[low];
            long firstHalf  =1L*low*num1 - sum2;
            long sum = firstHalf + secondHalf;
            list.add(sum);
        }
        return list;
    }
}
