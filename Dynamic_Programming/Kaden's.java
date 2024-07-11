// User function Template for Java
class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int[] arr) {
        long max = Integer.MIN_VALUE;
        long sum = 0;
        // Your code here
        for(int i =0; i < arr.length;i++) {
            sum = sum + arr[i];
            if(sum  < 0) {
                if(sum > max) {
                    max = sum;
                }
                sum = 0;
            }
            else {
                if(sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
