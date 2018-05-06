public class Range_Sum_Query_Mutable_307 {
    /*
    Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

    The update(i, val) function modifies nums by updating the element at index i to val.
    Example:
    Given nums = [1, 3, 5]

    sumRange(0, 2) -> 9
    update(1, 2)
    sumRange(0, 2) -> 8
    Note:
    The array is only modifiable by the update function.
    You may assume the number of calls to update and sumRange function is distributed evenly.
     */
    int[] bit;
    int[] n;
    public Range_Sum_Query_Mutable_307(int[] nums){
        if (nums == null || nums.length == 0) return;
        this.bit = new int[nums.length + 1];
        this.n = nums;
        //build binary indexed tree
        for (int i = 0; i < nums.length; i++){
            init(i, nums[i]);
        }
    }

    public void update(int i, int val){
        int diff = val - n[i];
        n[i] = val;
        init(i, diff);
    }

    public int sumRange(int i, int j){
        return sum(j) - sum(i - 1);
    }

    public void init(int index, int val){
        for (int i = index + 1; i < bit.length; i += i & (-i)){
            bit[i] += val;
        }
    }

    public int sum(int index){
        int sum = 0;
        for (int i = index + 1; i > 0; i -= i & (-i)){
            sum += bit[i];
        }
        return sum;
    }

    /*
    class NumArray {
    int[] nums;
    int[] bit;
    public NumArray(int[] nums) {
        this.nums = nums;
        if(nums.length == 0) return;
        int length = 1;
        for(int i = 0;  i < nums.length; i++){
            if(Math.pow(2, i) >= nums.length){
                length = (int)Math.pow(2, i);
                break;
            }
        }
        this.bit = new int[2 * length - 1];
        buildTree(nums, bit, 0, nums.length - 1, 0);
    }
    public void buildTree(int[] nums, int[] bit, int start, int end, int pos){
        if(start == end){
            bit[pos] = nums[start];
            return;
        }
        int mid = start + (end - start)/2;
        buildTree(nums, bit, start, mid, 2 * pos + 1);
        buildTree(nums, bit, mid + 1, end, 2 * pos + 2);
        bit[pos] = bit[2 * pos + 1] + bit[2 * pos + 2];
    }
    public void update(int i, int val) {
        // nums[i] = val;
        // buildTree(nums, bit, 0, nums.length - 1, 0);
        //update(nums, bit, i, val, )好像优化不了 = =
    }

    public int sumRange(int i, int j) {
        return helper(nums, bit, i, j, 0, nums.length - 1, 0);
    }
    public int helper(int[] nums, int[] bit, int low, int high, int curStart, int curEnd, int pos){
        if(low <= curStart && high >= curEnd){
            return bit[pos];
        }
        if(low > curEnd || high < curStart){
            return 0;
        }
        int mid = curStart + (curEnd - curStart)/2;
        return helper(nums, bit, low, high, curStart, mid, 2 * pos + 1) + helper(nums, bit, low, high, mid + 1, curEnd, 2 * pos + 2);
    }
}
     */
}
