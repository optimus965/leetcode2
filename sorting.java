class solution {
    private boolean more(int a, int b) {
        return a > b;
    }
    public void BubbleSort(int[] arr) {
        int size = arr.length;
        for(int  i =0;i < size - 1;i++) {
            for(int j =0;j < size - i - 1;j++) {
                if(this.more(arr[j],arr[j + 1])) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public void Bubble_sort(int[] arr) {
        int size = arr.length;
        int swapped = 1;
        for(int i =0;i < size - 1 && swapped == 1;i++) {
            swapped = 0;
            for(int j =0;j < size - 1 - i;j++) {
                if(this.more(arr[j],arr[j + 1])) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = 1;
                }
            }
        }
    }
    public void insertionSort(int[] nums) {
        int size = nums.length;
        int temp,j;
        for(int i = 1;i < size;i++) {
            temp = nums[i];
            for(j = i; j > 0 && this.more(nums[j - 1],temp);j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = temp;
        }
    }
    public void selectionSort(int[] arr) {
        for(int i =0;i < arr.length - 1;i++) {
            int max = 0;
            for(int j = 1;j < arr.length - i - 1;j++) {
                if(arr[j] > arr[max]) {
                    max = j;
                }
            }
            int temp = arr[max];
            arr[max] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }
    public void mergeSort(int[] nums,int start,int end) {
        if(start  >= end) {
            return;
        }
        int mid = (start + end) >> 1;
        mergeSort(nums,start,mid);
        mergeSort(nums,mid + 1,end);
        int lowStart = start;
        int upperStart = mid + 1;
        int count = 0;
        int[] array = new int[end - start + 1];
        while(lowStart <= mid && upperStart <= end) {
            if(nums[lowStart] < nums[upperStart]) {
                array[count++] = nums[lowStart++];
            }
            else {
                array[count++] = nums[upperStart++];
            }
        }
        while(lowStart <= mid) {
            array[count++] = nums[lowStart++];
        }
        while(upperStart <= end) {
            array[count++] = nums[upperStart++];
        }
        if (count >= 0) System.arraycopy(array, 0, nums, start + 0, count);
    }
}
public class sol {
    public static void main(String[] args) {
        int[] nums= {9,63,3,23,5,7,8,2,2};
        solution n = new solution();
        n.mergeSort(nums,0,nums.length - 1);
        for(int c:nums) {
            System.out.println(c);
        }
    }
}
