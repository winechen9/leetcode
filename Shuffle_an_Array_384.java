import java.util.*;
public class Shuffle_an_Array_384 {
    /*
    Shuffle a set of numbers without duplicates.

    Example:

    // Init an array with set 1, 2, and 3.
    int[] nums = {1,2,3};
    Solution solution = new Solution(nums);

    // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
    solution.shuffle();

    // Resets the array back to its original configuration [1,2,3].
    solution.reset();

    // Returns the random shuffling of array [1,2,3].
    solution.shuffle();
     */
    Random rmd;
    int[] nums;
    public Shuffle_an_Array_384(int[] nums) {
        this.rmd = new Random();
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] copy = nums.clone();
        for(int i = 1; i < nums.length; i++){
            int rIndex = rmd.nextInt(i + 1);
            if(rIndex != i){
                swap(copy, rIndex, i);
            }
        }

        return copy;
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
