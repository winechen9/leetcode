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
}
