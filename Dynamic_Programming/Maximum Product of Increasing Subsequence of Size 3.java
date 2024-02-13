class MaximumProduct{
    
    // Function to find subsequence of size 3 with maximum product
    // arr[]: input array
    // n: size of array
    // res[]: array contianing the subsequence of size 3 with max product
    static void maxProductSubsequence(int arr[], int n, long res[]) { 
        
        // Your code here
        int[] right = new int[n];
        int max2 =0;
        for(int i =  n - 2;i >= 0;i--) {
            max2 = Math.max(max2,arr[i + 1]);
            right[i] = max2;
        }
        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(arr[0]);
        long max = -1;
        for(int i = 1;i < n - 1;i++) {
            int find = tree.lower(arr[i]) != null ? tree.lower(arr[i]):-1;
            int max1 = right[i];
            if(find != -1 && max1 > arr[i]) {
                long value = (long)find*(long)arr[i]*(long)max1;
                if(value > max) {
                    max = value;
                    res[0] = (long)find;
                    res[1] = (long)arr[i];
                    res[2] = (long)right[i];
                    }
            }
            tree.add(arr[i]);
        }
        
    }
    
}
