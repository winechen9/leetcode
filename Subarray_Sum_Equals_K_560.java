import java.util.HashMap;
import java.util.*;

public class Subarray_Sum_Equals_K_560 {
    /*
    Given an array of integers and an integer k, you need to find the total number of continuous subarrays
    whose sum equals to k.

    Example 1:
    Input:nums = [1,1,1], k = 2
    Output: 2
    Note:
    The length of the array is in range [1, 20,000].
    The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

    第一反应是用sliding window，但是因为这里并不是都是non-negative number，所以并行不通，所以感觉更像是2 sum的思想，
    就是找剩下的数有没有满足和target关系的数。只不过这里是连续的数组subarray。所以类似于segment tree的最初始的想法，
    就是把数组到每个值时的总和加起来。[2,1,5,7,3] -> [2,3,8,15,18], 把每个sum和它的个数存进hashmap，只要用sum – k ，
    如k = 12, 则15 - 12= 3,存在于hashmap中，则[2,3]这个区间的sum为12. 就是用当前所有数字的总和，减掉要求的target，
    剩下的数字如果在map中就说明前面存在这么一段区间使得条件成立。

     */
    public int subarraySum(int[] nums, int k){
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (map.containsKey(sum - k)){
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
