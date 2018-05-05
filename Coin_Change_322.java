import java.util.*;
public class Coin_Change_322 {
    /*
    You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

    Example 1:
    coins = [1, 2, 5], amount = 11
    return 3 (11 = 5 + 5 + 1)

    Example 2:
    coins = [2], amount = 3
    return -1.

    Note:
    You may assume that you have an infinite number of each kind of coin.
    这道题的转移方程还是比较好想的，就是等于每一个上一个面值的数量加一，dp[i - num] + 1 = dp[i].
    取所有可能的数量里最小的那个，所以要维护一个局部min，初始化为最大的Integer。然后每次遍历所有coins，算出最小值，
    并且限制为了加快速度，直接可以排除掉上一个面值可能的数量为-1的情况，因为上一种就不可能，这次的肯定也不可能实现。
    如果一个都没可能的话，min会依然保持最大值，所以只要判定一下如果还是最大值的话，那就是找不到，为-1。
    */
    public int coinChange(int[] coins, int amount){

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++){
            int min = Integer.MAX_VALUE;
            for(int num: coins){
                if(i >= num && dp[i - num] >= 0){
                    min = Math.min(dp[i - num] + 1, min);
                }
                dp[i] = min == Integer.MAX_VALUE? dp[i] : min;
            }
        }
        return dp[dp.length - 1];
    }
}
