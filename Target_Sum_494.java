public class Target_Sum_494 {

    /*
    经典的dp（背包问题）题，也可以用dfs来枚举所有可能的结果，看有没有符合target值的。
    用dp的复杂度就降为了n * (2 * sum + 1) = n * S
    初始条件是一个数都没有的时候结果为0的可能的方法个数是1
    dp[i][j]的后者说明的是-sum有多少种，一般一开始就是0种，
    直到在0（sum）的周围，
    dp[1][sum + 1] += dp[0][sum + 1 – nums[0] ]（1）dp[1][sum – 1(即-1)] += dp[0][sum – 1 + 1]

     */
    public int findTargetSumWays(int[] nums, int s){
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        //可能取到的最大绝对值
        for (int num : nums){
            sum += num;
        }
        if (s > sum || s < -sum) return 0;
        int[][] dp = new int[nums.length + 1][2 * sum + 1];
        dp[0][0 + sum] = 1;//0是负的和，和则是0
        for (int i = 1; i <= nums.length; i++){
            //遍历原始数组
            for (int j = 0; j < 2 * sum + 1; j++){
                if (j + nums[i - 1] < 2 * sum + 1) dp[i][j] += dp[i - 1][j + nums[i - 1]];
                if (j - nums[i - 1] >= 0) dp[i][j] += dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[nums.length][sum + s];
    }
}
