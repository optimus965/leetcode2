class Solution 
{ 
    static long ValidPair(int nums[], int n) 
	{ 
	    // Your code goes here
	    long sum = 0;
	    Arrays.sort(nums);
	    for(int i =0;i < n;i++) {
	        int low = i;
	        int high  = n - 1;
	        int ans =  -1;
	        if(nums[low] <  0) {
	            int target = -nums[low];
	            while(low <= high) {
	            int mid = (low + high) >> 1;
	            if(nums[mid] > target) {
	                ans = mid;
	                high = mid - 1;
	            }
	            else {
	                low = mid + 1;
	            }
	            }
	            if(ans != -1) {
	                sum = sum + (n - ans);
	            }
	        }
	        else {
	            sum = sum + (n - low - 1);
	            
	        }
	    }
	    return sum;
	}
} 
