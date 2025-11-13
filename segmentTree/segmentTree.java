class NumArray {
    int[] store;
    int[] nums;
    int n;
    int[][] rangestore;
    public NumArray(int[] nums) {
        this.nums = nums;
        this.n  = nums.length;
        this.store = new int[4*n];
        this.rangestore = new int[4*n][2];
        this.build(nums,1,0,n - 1);
    }
    public void build(int[] nums,int point,int left, int right) {
        rangestore[point] = new int[]{left,right};
        if(left == right) {
            store[point] = nums[left];
            return;
        }
        int mid = (left + right) >> 1;
        build(nums,2*point,left,mid);
        build(nums,2*point + 1, mid + 1,right);
        store[point] = store[2*point] + store[2*point + 1];
    }
    
    public void update(int index, int val) {
        this.update1(index,val,1);
    }
    public void update1(int index,int val,int start) {
        int[] range = rangestore[start];
        if(index == range[0] && index == range[1]) {
            this.store[start] =  val;
        } 
        else if(index >= range[0] && index <= range[1]) {
            update1(index,val,2* start);
            update1(index,val,2* start + 1);
            this.store[start] = this.store[2*start] + this.store[2*start + 1];
        }
    }
    public int sum1(int left, int right,int start) {
        int[] range = rangestore[start];

        if(range[0] > right || range[1] < left) {
            return 0;
        }
        if(left <= range[0] && right >= range[1]) {
            return store[start];
        }
        return sum1(left, right,2*start) + sum1(left,right,2*start + 1);

    }
    public int sumRange(int left, int right) {
        return this.sum1(left, right,1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
