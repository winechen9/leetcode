import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.*;

public class Partition_Equal_Subset_Sum_416 {
    /*
    典型的背包问题，用dp来解决。也是先求sum，然后因为要求两边各一半，所以只要求sum/2是不是有可能得到就可以了
    因为下一个仅依赖于上一个，所以只要用一个1d array就可以做到了
     */
    public boolean canPartition(int[] nums){
        if (nums == null || nums.length < 2) return false;
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (sum % 2 != 0) return false;//奇数的话不合法
        sum /= 2;

        boolean[][] dp = new boolean[nums.length + 1][sum + 1];//include 0
        dp[0][0] = true; //0个数可以组成sum = 0
        for (int i = 0; i < dp.length; i++){
            dp[i][0] = true;
        }
        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j < sum + 1; i++){
                dp[i][j] = dp[i - 1][j];//不取当前数的情形
                //如果要取当前数，则如果当前的数字大于j，说明肯定是不pick的情形
                if (j >= nums[i - 1]){
                    dp[i][j] = (dp[i][j] || dp[i - 1][j - nums[i - 1]]);
                    //上一次取i - 1个数时，与当前的j正好相差一个nums[i - 1]为true的情形
                    //如dp[4][11] = dp[3][11 - 5] = true
                }
            }
        }
        return dp[dp.length - 1][sum];
    }

    /*
    1d array
    为了避免override dp[i - num], 所有从右往左写
     */
    public boolean canPartition2(int[] nums){
        if (nums.length < 2) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 == 1) return false;
        sum /= 2;

        int n = nums.length;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;




        for (int i = 0; i < n; i++){
            for (int j = sum; j > 0; j--){
                if (j >= nums[i]){
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }
}
