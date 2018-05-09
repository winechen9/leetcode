public class Increasing_Triplet_Subsequence_334 {
    /*
    Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

    Formally the function should:
    Return true if there exists i, j, k
    such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
    Your algorithm should run in O(n) time complexity and O(1) space complexity.

    Examples:
    Given [1, 2, 3, 4, 5],
    return true.

    Given [5, 4, 3, 2, 1],
    return false.

    这题要注意[1,1,1,1,1]这种相等的情况，就一定要num <= min就要更新，要不然secMin就会变成一样的数，就不符合increasing triplet
    的要求了。
     */

    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= min){
                min = nums[i];
            }else if(nums[i] <= secMin){
                secMin = nums[i];
            }else return true;
        }
        return false;
    }
}
