import java.util.*;
public class Valid_Triangle_Number_611 {
    /*
    每次都是先定下两个最大值，找到可以满足两短边之和大于最大边的，就把hihg - low的长度加进去，然后把high缩进去。
    看看有没有更多可能性。否则的话，就low++来找到第一个满足条件的地方。
     */

    public int triangleNumber(int[] nums) {
        if(nums.length < 3) return 0;
        Arrays.sort(nums);
        int count = 0;
        for(int i = nums.length - 1; i >= 2; i--){
            int low = 0;
            int high = i - 1;
            while(low < high){
                if(nums[low] + nums[high] > nums[i]){
                    count += (high - low);
                    high--;
                }else {
                    low++;
                }
            }
        }
        return count;
    }
}
