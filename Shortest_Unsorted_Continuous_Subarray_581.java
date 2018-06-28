import java.util.Arrays;

public class Shortest_Unsorted_Continuous_Subarray_581 {
    /*
    比较好想的是sort，要找出一段不是在整段数组中正序的数，就是跟排完序的数组比较，
    前后短不跟数组严格相等的就是需要reorder的了
    如果用one pass的话，就像那道找出两个交换过的nodes的题一样，把不满足条件的头和尾都记录下来
     */
    public int findUnsortedSubarray(int[] nums){
        int n = nums.length;
        int[] tmp = nums.clone();
        Arrays.sort(tmp);
        int start = 0;
        while (start < n && nums[start] == tmp[start]) start++;

        int end = n - 1;
        while (end > start && nums[end] == tmp[end]) end--;
        return end - start + 1;
    }
    /*
    从一开始的想法，就是在insertion sort的过程中，一旦出现一个比前一个数小的数，就更新end的initial想法开始，
    可以引申为只记录最大值，如果当前值比最大值小的话，说明要更新end，另一方面是左边的所有元素都小于中间段的元素，
    满足条件的中间段的元素就是good的
    就是从左到右找一个比较小的作为end，同时从右到左找一个左边大于右边的数作为begin
     */

    public int findUnsortedSubarray2(int[] nums) {
        int n = nums.length;
        int begin = -1;
        int end = -2;
        int min = nums[n - 1], max = nums[0];

        for (int i = 1; i < n; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - 1 - i]);
            if (max > nums[i]) end = i;
            if (min < nums[n - 1 - i]) begin = n - 1 -i;
        }
        return end - begin + 1;
    }
}
