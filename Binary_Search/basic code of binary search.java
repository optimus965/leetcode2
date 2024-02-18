class Solution {
  // Checking for the element using binary search
    int binarysearch(int arr[], int n, int k) {
        // code here
        int low = 0;
        int high = n - 1;
        while(low <= high) {
            int mid = (low + high) >> 1;
            if(arr[mid]== k) return mid;
            if(arr[mid] < k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
  // checking for the lower bound of the element in the given array
  public  int lowerBound(int []arr, int n, int x) {
        // Write your code here
        int ans = n;
        int low = 0;
        int high = n - 1;
        while(low <= high) {
            int mid = (low + high) >> 1;
            if(arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

  // Checking for the upper bound of the element in the given array
  public  int upperBound(int []arr, int x, int n){
        // Write your code here.
        int ans = -1;
        int low = 0;
        int high = n - 1;
        while(low <= high){
            int mid = (low + high) >> 1;
            if(arr[mid] <= x) {
              ans = mid;
                low = mid + 1;
            }
            else {
                high =  mid - 1;
            }
        }
        return ans;
    }
  
}
