public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        return this.sol(nums1,nums2,k);
    }
    public int[] sol(int[] nums1,int[] nums2,int k) {
        int start = Math.max(k - nums2.length,0);
        int end = Math.min(nums1.length,k);
        int[] nums = new int[k];
        for(int i = start;i <= end;i++) {
            int[] first = new int[i];
            int[] second = new int[k - i];
            int[] result = new int[k];
            first = this.max(nums1,i);
            second = this.max(nums2,k - i);
            int start1 = 0,start2  =0,counter =0;
            int i1 = 0,j1 = 0;
            while(i1  < first.length && j1 < second.length) {
                if(first[i1] == second[j1]) {
                    int temp1 = i1;
                    int temp2 = j1;
                    while(temp1 < first.length && temp2 < second.length && first[temp1] == second[temp2]) {
                        temp1++;
                        temp2++;
                    }
                    if(temp1 == first.length) {
                        result[counter++] = second[j1++]; 
                    }
                    else if(temp2 == second.length) {
                        result[counter++] = first[i1++];
                    }
                    else {
                        if(first[temp1] > second[temp2]) {
                            result[counter++] = first[i1++];
                        }
                        else {
                            result[counter++] = second[j1++];
                        }
                    }
                }
                else if(first[i1] > second[j1]) {
                    result[counter++] = first[i1++];
                }
                else {
                    result[counter++] = second[j1++];
                }
            }
            while(i1 < first.length) {
                result[counter++] = first[i1++];
            }
            while(j1 < second.length) {
                result[counter++] = second[j1++];
            }
            boolean visited = false;
            start1 = 0;
            start2 = 0;
            while(start1 < result.length || start2 < nums.length) {
                if(result[start1] > nums[start2]) {
                    visited = true;
                    break;
                }
                else if(nums[start2] > result[start1]) {
                    break;
                }
                else {
                    start1++;
                    start2++;
                    if(start1 == result.length) {
                        visited = true;
                    }
                    
                }
            }
            if(visited) {
                nums  = result;
            }

        }
        return nums;
    }
    
    public int[] max(int[] nums,int k) {
        int[] res = new int[k];
        int len =0;
        for(int i =0;i < nums.length;i++) {
            while( len > 0 && res[len - 1] < nums[i] && k - len < nums.length - i) {
                len--;
            }
            if(len < k) {
                res[len++] = nums[i];
            }
        }
        return  res;
    }
}
